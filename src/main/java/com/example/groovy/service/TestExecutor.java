package com.example.groovy.service;

import com.example.groovy.actions.ActionHandler;
import com.example.groovy.actions.ActionType;
import com.example.groovy.configuration.properties.ScriptsProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nikolay.mikutskiy
 * Date: 25.01.2021
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TestExecutor {
    private final ScriptsProperties scripts;
    private final List<ActionHandler> actionHandlers;
    private final Map<ActionType, ActionHandler> handlers = new HashMap<>();

    @PostConstruct
    public void TestNow() {
        actionHandlers.forEach(actionHandler -> handlers.put(actionHandler.getActionType(), actionHandler));

        //test execution
        scripts.getActions().forEach((code, action) -> {
            ActionHandler handler = handlers.get(action.getType());
            handler.handle(code, action);
        });

    }
}
