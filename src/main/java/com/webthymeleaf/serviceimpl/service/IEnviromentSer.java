package com.webthymeleaf.serviceimpl.service;

import com.webthymeleaf.entity.Environment;
import com.webthymeleaf.entity.ThongSo;
import org.springframework.stereotype.Service;

@Service
public interface IEnviromentSer {

    ThongSo getEnviromentBy(String id);
}
