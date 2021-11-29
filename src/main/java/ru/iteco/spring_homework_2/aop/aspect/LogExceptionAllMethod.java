package ru.iteco.spring_homework_2.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogExceptionAllMethod {

    @AfterThrowing(value = "allMethodInServiceException()", throwing = "exception")
    public void afterAllMethodInServiceExceptionAdvice(JoinPoint joinPoint, Exception exception) {
        log.info("afterAllMethodInServiceExceptionAdvice:: END {} WITH THROW: {}",
                joinPoint.getSignature().toShortString(), exception.toString());
    }

    @Pointcut("within(ru.iteco.spring_homework_2.aop.service.*)")
    public void allMethodInServiceException() {

    }
}
