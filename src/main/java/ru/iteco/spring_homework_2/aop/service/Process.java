package ru.iteco.spring_homework_2.aop.service;

import ru.iteco.spring_homework_2.aop.model.ExternalInfo;

public interface Process {
    Boolean run(ExternalInfo externalInfo) throws Exception;
}
