package ai.leantech.jpatest.service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    @Pointcut("within(ai.leantech.jpatest.service.SimpleSpringAspectOrientedProgrammingLoggingUserExampleService)")
    public void loggingMethods() {
        //log.info("pointcut");
    }

    @After("loggingMethods()")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature()
                .getName();
        log.info("Service {} method was called.", methodName);
    }
}
