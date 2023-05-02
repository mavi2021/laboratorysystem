package com.cqupt.laboratorysystem.aspect;

import com.cqupt.laboratorysystem.annotation.Limit;
import com.cqupt.laboratorysystem.utils.RedisClient;
import com.google.common.collect.ImmutableList;
import io.swagger.models.auth.In;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2023/5/2 21:04
 */
@Aspect
@Component
public class LimitAspect {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private RedisClient redisClient;

    @Pointcut("@annotation(com.cqupt.laboratorysystem.annotation.Limit)")
    public void pointcut(){
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Limit limit = signature.getMethod().getAnnotation(Limit.class);
        String type = limit.type();

        String luaScript = redisClient.buildLuaScript();
        RedisScript<Number> redisScript = new DefaultRedisScript<>(luaScript, Number.class);
        ArrayList<String> keys = new ArrayList<>();
        keys.add(limit.prefix());
        keys.add(signature.getMethod().getName());
        keys.add(limit.prefix());
        keys.add(limit.prefix());

        String requestNum = String.valueOf(limit.requestNum());
        String period = String.valueOf(limit.period());

//        Number count = redisTemplate.execute(redisScript, keys, limit.requestNum());
//        System.out.println(count);

        System.out.println("执行前");
        System.out.println("对" + type + "统计访问");
        return joinPoint.proceed();
    }


}
