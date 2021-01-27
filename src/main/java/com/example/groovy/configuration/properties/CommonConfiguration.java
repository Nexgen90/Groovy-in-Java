package com.example.groovy.configuration.properties;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by nikolay.mikutskiy
 * Date: 26.01.2021
 */
@Configuration
public class CommonConfiguration {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
//                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }
}
