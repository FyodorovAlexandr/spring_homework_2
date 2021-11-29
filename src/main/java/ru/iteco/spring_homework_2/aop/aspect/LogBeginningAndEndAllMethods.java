package ru.iteco.spring_homework_2.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogBeginningAndEndAllMethods {

    @Before("allMethodInService()")
    public void beforeAllMethodInServiceAdvice(JoinPoint joinPoint) {
        log.info("beforeAllMethodInServiceAdvice:: START {}", joinPoint.getSignature().toShortString());
    }

    @After("allMethodInService()")
    public void afterAllMethodInServiceAdvice(JoinPoint joinPoint) {
        log.info("afterAllMethodInServiceAdvice:: END {}", joinPoint.getSignature().toShortString());
    }

    @Pointcut("within(ru.iteco.spring_homework_2.aop.service.*)")
    public void allMethodInService() {

    }
}
