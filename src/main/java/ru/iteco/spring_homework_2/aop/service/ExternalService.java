package ru.iteco.spring_homework_2.aop.service;

import ru.iteco.spring_homework_2.aop.model.ExternalInfo;

public interface ExternalService {
    ExternalInfo getExternalInfo(Integer id) throws Exception;
}
