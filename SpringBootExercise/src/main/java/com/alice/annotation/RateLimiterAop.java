package com.alice.annotation;

import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 2019年12月16日22:55:50
 *
 * @author liusc
 * 功能说明:使用AOP环绕通知判断拦截所有springmvc 请求，判断请求方法上是否存在ExtRateLimiter <br>
 * * 1.判断请求方法上是否有@ExtRateLimiter<br>
 * * 2.如果方法上存在@ExtRateLimiter注解话<br>
 * * 3.使用反射技术获取@ExtRateLimiter注解方法上的参数<br>
 * * 4.调用原生RateLimiter代码创建令牌桶<br>
 * * 5.如果获取令牌超时的，直接调用服务降级方法（需要自己定义）<br>
 * * 6.如果能够获取令牌的话，直接进入实际请求方法。<br>
 * * AOP创建方式有两种 注解版本和XML方式<br>
 */

@Aspect
@Component
public class RateLimiterAop {

    private Map<String,RateLimiter> rateHashMap = new ConcurrentHashMap<String,RateLimiter>();

    //定义切入点 com.alice.api
    @Pointcut("execution(public * com.alice.api.*.*(..))")
    public void rlAop() {
    }


    @Around("rlAop()")
    public Object doBefore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        /**
         * 1.如果请求方法上存在@ExtReLimiter注解的话
         * 2.使用Java的反射机制获取拦截方法上自定义注解的参数
         * 3.调用原生的RateLimiter创建令牌 保证每个请求对应都是单例的RateLimiter
         * 4.获取令牌桶中的令牌,如果在有效期内没有获取到令牌的话,则直接调用本地服务降级方法,不会进入到实际请求方法中
         * 5.获取令牌桶中的令牌,如果能获取到令牌,则直接进入到实际请求方法中
         */

        Method singatureMethod = getSingatureMethod(proceedingJoinPoint);

        if (singatureMethod == null) {
            return null;
        }
        ExtRateLimiter extRateLimiter = singatureMethod.getDeclaredAnnotation(ExtRateLimiter.class);
        if (extRateLimiter == null){
            return proceedingJoinPoint.proceed();
        }
        double permitsPerSecond = extRateLimiter.permitsPerSecond();
        long timeout = extRateLimiter.timeout();




        return null;
    }

    /**
     * 获取到aop中的方法
     *
     * @param proceedingJoinPoint
     * @return
     */
    private Method getSingatureMethod(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        return method;
    }

}
