package com.webthymeleaf.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.webthymeleaf.repository")
@EntityScan(basePackages= {"com.webthymeleaf.entity","com.webthymeleaf.dto"})
@EnableAutoConfiguration
@EnableTransactionManagement
public class JPAConfig {
}
