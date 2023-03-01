package com.webthymeleaf.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThongSo {
    private String temperature;
    private String humidity;
    private String lightIntensity;
    private String soilHumidity;
    private String currentTime;

}
