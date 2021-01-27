package com.example.groovy.actions;

import com.example.groovy.configuration.properties.ScriptsProperties;

/**
 * Created by nikolay.mikutskiy
 * Date: 26.01.2021
 */
public interface ActionHandler {
    void handle(String code, ScriptsProperties.Action action);
    ActionType getActionType();
}
