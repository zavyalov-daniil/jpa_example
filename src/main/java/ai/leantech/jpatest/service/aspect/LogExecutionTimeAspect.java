package ai.leantech.jpatest.service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogExecutionTimeAspect {
    @Around("@annotation(LogExecutionTime)")
    public Object logExTime(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = jp.proceed();

        long executionTime = System.currentTimeMillis() - start;
        log.info("{} executed in {}ms", jp.getSignature().getName(), executionTime);
        return proceed;
    }
}
