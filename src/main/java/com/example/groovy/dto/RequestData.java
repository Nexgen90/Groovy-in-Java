package com.example.groovy.dto;

import lombok.Data;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nikolay.mikutskiy
 * Date: 26.01.2021
 */
@Data
public class RequestData {
    private HttpMethod method;
    private UriBuilder uriBuilder;
    private Map<String, Object> uriVariables = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();
    private Object body;
}
