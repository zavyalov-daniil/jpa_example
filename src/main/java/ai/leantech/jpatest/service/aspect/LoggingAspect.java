package ai.leantech.jpatest.service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    @Pointcut("within(ai.leantech.jpatest.service.SimpleAspectOrientedProgrammingLoggingUserService)")
    public void serviceMethods() {
        //Метод должен быть пустым
    }

    @Before("serviceMethods()")
    public void logMethodCall(JoinPoint joinPoint) {
        log.info(
                "{} method {} executed with {} arguments",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().toShortString(),
                joinPoint.getArgs()
        );
    }

    @After("serviceMethods()")
    public void logMethodComplete(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature()
                .getName();
        log.info("Service method {} was completed.", methodName);
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logMethodResult(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature()
                .getName();
        log.info("Service method {} return {}", methodName, result);
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "e")
    public void logIllegalArgumentExceptionInService(JoinPoint joinPoint, Throwable e) {
        log.error(
                "Service method {} with params {} was completed with {}",
                joinPoint.getSignature().getName(),
                joinPoint.getArgs(),
                e.getClass().getName(),
                e
        );
    }

    @Around("execution(public * ai.leantech.jpatest.service.SimpleAspectOrientedProgrammingLoggingUserService.save*(*))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            log.info("{}: Retrying operation", proceedingJoinPoint.getSignature());
            return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        }
    }
}
