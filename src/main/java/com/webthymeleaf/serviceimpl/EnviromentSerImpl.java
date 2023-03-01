package com.webthymeleaf.serviceimpl;

import com.google.gson.Gson;
import com.webthymeleaf.entity.Environment;
import com.webthymeleaf.entity.ThongSo;
import com.webthymeleaf.repository.EnvironmentRepo;
import com.webthymeleaf.serviceimpl.service.IEnviromentSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnviromentSerImpl implements IEnviromentSer {
    @Autowired
    EnvironmentRepo environmentRepo ;


    @Override
    public ThongSo getEnviromentBy(String id) {
        List<Environment> environment = environmentRepo.findEnviromentByID(id);
        String text = environment.get(0).getEnvironmentData() ;
        Gson g = new Gson();
        ThongSo me = g.fromJson(text, ThongSo.class);
        System.out.println(environment);
        System.out.println(me.getHumidity());
        System.out.println(me.getHumidity());
        System.out.println(me.getLightIntensity());
        System.out.println(me.getTemperature());
        return me;
    }
}
