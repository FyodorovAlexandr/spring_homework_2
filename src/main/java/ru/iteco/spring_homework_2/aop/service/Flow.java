package ru.iteco.spring_homework_2.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.iteco.spring_homework_2.aop.model.ExternalInfo;

@Slf4j
@Component
public class Flow {

    private final ExternalService externalService;
    private final Process process;

    public Flow(ExternalService externalService, Process process ) {
        this.externalService = externalService;
        this.process = process;
    }

    public void run(Integer id) throws Exception {
        ExternalInfo externalInfo = externalService.getExternalInfo(id);
        if (externalInfo.getInfo() != null) {
            process.run(externalInfo);
        } else {
            log.info("Not run process: {}", externalInfo);
        }
    }
}

