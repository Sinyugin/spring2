package ru.geekbrains.spring2.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ProductServiceAspect {

    @Pointcut("execution (* ru.geekbrains.spring2.services.ProductService.*(..))")
    public void servicePointcut() {
    }

    @Before("servicePointcut()")
    public void beforeService(JoinPoint jp) {

        MethodSignature signature = (MethodSignature) jp.getSignature();
        log.info("Вызван метод {} в классе #ProductService", signature.getMethod().getName());

    }

    @After("servicePointcut()")
    public void afterService(JoinPoint jp) {

        MethodSignature signature = (MethodSignature) jp.getSignature();
        log.info("Отработал метод {} в классе #ProductService", signature.getMethod().getName());
    }
}
