package ru.iteco.spring_homework_2.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.iteco.spring_homework_2.aop.model.ExternalInfo;

@Slf4j
@Aspect
@Component
public class CheckRequestAspect {

    @Value("${id}")
    private Integer idNotProcess;

    @Around("allMethodMarkCheckRequestAnnotation(externalInfo)")
    public void aroundAllMethodMarkCheckRequestAnnotationAndHaveExternalInfoInArg(ProceedingJoinPoint proceedingJoinPoint,
                                                                                  ExternalInfo externalInfo) throws Throwable {
        log.info("CHECK REQUEST: {} with {}", proceedingJoinPoint.getSignature().toShortString(), externalInfo);
        if (!idNotProcess.equals(externalInfo.getId())) {
            log.info("ALLOW REQUEST");
            proceedingJoinPoint.proceed();
        }
    }

    @Pointcut("@annotation(ru.iteco.spring_homework_2.aop.annotations.CheckRequest) && args(externalInfo, ..)")
    public void allMethodMarkCheckRequestAnnotation(ExternalInfo externalInfo) {
    }

}
