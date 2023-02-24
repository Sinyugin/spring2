package ru.geekbrains.spring2.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Slf4j
@Component
public class TimerAspect {

    @Pointcut("@annotation(Timer)")
    public void annotationMethod(){

    }
@Around("annotationMethod()")
    public Object annotationMethod(ProceedingJoinPoint pjp) throws Throwable{
    Long start = System.currentTimeMillis();
    Object proceed = pjp.proceed();
    Long executionTime  = System.currentTimeMillis() - start;
    log.info("Метод {} выполнялся {} ms", pjp.getSignature().getName(), executionTime);
        return proceed;
}

}
