package com.example.groovy.actions.log;

import com.example.groovy.actions.ActionHandler;
import com.example.groovy.actions.ActionType;
import com.example.groovy.configuration.properties.ScriptsProperties;
import com.example.groovy.service.ScriptLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by nikolay.mikutskiy
 * Date: 26.01.2021
 */
@Component
@RequiredArgsConstructor
public class LogHandler implements ActionHandler {
    private final ScriptLoader scriptLoader;

    @Override
    public void handle(String code, ScriptsProperties.Action action) {
        LogAction logAction = scriptLoader.load(code, action.getScript(), LogAction.class);
        logAction.logData("Магия!!! -> " + action.getDescription());
    }

    @Override
    public ActionType getActionType() {
        return ActionType.LOG;
    }
}
