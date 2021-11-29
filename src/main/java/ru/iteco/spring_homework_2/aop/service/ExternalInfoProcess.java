package ru.iteco.spring_homework_2.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.iteco.spring_homework_2.aop.annotations.CheckRequest;
import ru.iteco.spring_homework_2.aop.model.ExternalInfo;

@Slf4j
@Component()
public class ExternalInfoProcess implements Process {

    @Value("${id}")
    private Integer idNotProcess;

    @CheckRequest
    @Override
    public Boolean run(ExternalInfo externalInfo) throws Exception {
        if (externalInfo.getId().equals(idNotProcess)) {
            throw new Exception("Exception: externalInfo.getId() equals idNotProcess");
        }
        return true;
    }
}
