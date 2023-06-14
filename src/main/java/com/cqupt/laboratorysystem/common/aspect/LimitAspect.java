package com.cqupt.laboratorysystem.common.aspect;

import com.cqupt.laboratorysystem.common.annotation.Limit;
import com.cqupt.laboratorysystem.common.utils.RedisClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static com.cqupt.laboratorysystem.common.utils.RedisConstants.LOCK_WEB_TRAFFIC;

/**
 * @create 2023/5/2 21:04
 */
@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class LimitAspect {

    private final RedisTemplate<String,Object> redisTemplate;
    private final RedisClient redisClient;

    @Pointcut("@annotation(com.cqupt.laboratorysystem.common.annotation.Limit)")
    public void pointcut(){
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Limit limit = signature.getMethod().getAnnotation(Limit.class);
        String type = limit.type();

        String luaScript = redisClient.buildLuaScript();
        RedisScript<Long> redisScript = new DefaultRedisScript<>(luaScript, Long.class);
        String methodName = signature.getMethod().getName();

        String scriptKey = StringUtils.join(LOCK_WEB_TRAFFIC, ":" ,methodName);
        Long count = redisTemplate.execute(redisScript, Collections.singletonList(scriptKey), limit.requestLimitMaxNum(), limit.period());
        if(count!=null && count<limit.requestLimitMaxNum()){
            log.info("对{}统计访问，访问{}方法次数：{}", type, methodName, count);
            return joinPoint.proceed();
        }else{
            throw new RuntimeException("访问次数受限制");
        }
    }

}
