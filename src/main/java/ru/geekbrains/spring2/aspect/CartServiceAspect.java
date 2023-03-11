package ru.geekbrains.spring2.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class CartServiceAspect {

    @Pointcut("execution (* ru.geekbrains.spring2.services.CartService.*(..))")
    public void servicePointcut() {
    }

    @Before("servicePointcut()")
    public void beforeService(JoinPoint jp) {

        MethodSignature signature = (MethodSignature) jp.getSignature();
        log.info("Вызван метод {} в классе #CartService", signature.getMethod().getName());
    }

    @AfterThrowing("servicePointcut()")
    public void afterThrowingCartService(JoinPoint jp){

        MethodSignature signature = (MethodSignature) jp.getSignature();
        log.info("Выполнение метода {} завершено с ошибкой", signature);
    }

    @AfterReturning("servicePointcut()")
    public void afterReturningCartService(JoinPoint jp){

        MethodSignature signature = (MethodSignature) jp.getSignature();
        log.info("Выполнение метода {} завершено успешно", signature.getName());
    }

    @After("servicePointcut()")
    public void afterService(JoinPoint jp) {

        MethodSignature signature = (MethodSignature) jp.getSignature();
        log.info("Отработал метод {} в классе #CartService", signature.getMethod().getName());
    }


}
