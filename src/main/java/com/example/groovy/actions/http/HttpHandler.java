package com.example.groovy.actions.http;

import com.example.groovy.actions.ActionHandler;
import com.example.groovy.actions.ActionType;
import com.example.groovy.configuration.properties.ScriptsProperties;
import com.example.groovy.service.ScriptLoader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by nikolay.mikutskiy
 * Date: 26.01.2021
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class HttpHandler implements ActionHandler {
    private final ScriptLoader scriptLoader;
    private final RestTemplate restTemplate;

    @Override
    public void handle(String code, ScriptsProperties.Action action) {
        HttpAction httpAction = scriptLoader.load(code, action.getScript(), HttpAction.class);

        ResponseEntity<String> response = restTemplate.getForEntity(httpAction.getUrl(), String.class);
        log.info("plainResponse = " + response);
        log.info("Response statusCode = " + response.getStatusCode());
    }

    @Override
    public ActionType getActionType() {
        return ActionType.HTTP;
    }
}
