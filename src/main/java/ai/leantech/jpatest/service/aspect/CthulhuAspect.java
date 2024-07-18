package ai.leantech.jpatest.service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class CthulhuAspect {
    @Around("@annotation(CallCthulhuAnnotation)")
    public Object callCthulhu(ProceedingJoinPoint jp) throws Throwable {
        log.warn("Ph’nglui mglw’nafh Cthulhu R’lyeh wgah’nagl fhtagn");
        return jp.proceed();
    }
}
