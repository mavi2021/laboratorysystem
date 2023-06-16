package com.cqupt.laboratorysystem.common.aspect;

import com.cqupt.laboratorysystem.common.dto.Result;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @create 2023/6/16 18:59
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.cqupt.laboratorysystem.common.annotation.Log)")
    public void pointcut(){

    }
    @Around("pointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        try {
            // 获取方法名
            String methodName = joinPoint.getSignature().getName();
            // 获取执行对象
            Class<?> object = joinPoint.getTarget().getClass();
            String objectName = object.getSimpleName();
            // 获取参数列表
            Object[] args = joinPoint.getArgs();
            // 获取更新之前的用户信息
            Long id = null;
            if(args[0] instanceof Long){
                id = (Long) args[0];
            }else {
                Field[] fields = args[0].getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);  // 设置可访问私有属性
                    if(field.getName().equals("id")){
                        id = (Long) field.get(args[0]);
                        break;
                    }
                }
            }

            log.info("开始执行{}对象的{}方法，对象ID: {}", objectName, methodName, id);
            // 调用目标方法
            result = joinPoint.proceed();
            // 记录操作日志net
            if (result instanceof Result) {
                log.info("执行成功");
            }
        } catch (Throwable e) {
            // 记录方法调用异常的日志
            log.error("执行失败：" + e.getMessage());
            throw e;
        }
        return result;
    }
}
