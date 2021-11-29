package ru.iteco.spring_homework_2.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.iteco.spring_homework_2.aop.annotations.CacheResult;
import ru.iteco.spring_homework_2.aop.model.ExternalInfo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ExternalServiceImpl implements ExternalService {

    private final Map<Integer, ExternalInfo> hashMap = new HashMap<>();

    public ExternalServiceImpl() {
    }

    @CacheResult
    @Override
    public ExternalInfo getExternalInfo(Integer id) throws Exception {
        if (hashMap.get(id) == null) {
            throw new Exception("Not found!");
        }
        return hashMap.get(id);
    }

    @PostConstruct
    public void init() {
        hashMap.put(1, new ExternalInfo(1, null));
        hashMap.put(2, new ExternalInfo(2, "hasInfo"));
        hashMap.put(3, new ExternalInfo(3, "info"));
        hashMap.put(4, new ExternalInfo(3, "information"));
        log.info("Filling HashMap with test data");
    }

    @PreDestroy
    public void destroy() {
        log.info("HashMap before: {}", hashMap);
        hashMap.clear();
        log.info("HashMap after: {}", hashMap);
        log.info("HashMap cleared");
    }
}
