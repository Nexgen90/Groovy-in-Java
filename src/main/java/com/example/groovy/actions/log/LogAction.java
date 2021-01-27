package com.example.groovy.actions.log;

import com.example.groovy.actions.ExternalAction;

/**
 * Created by nikolay.mikutskiy
 * Date: 25.01.2021
 */
public interface LogAction extends ExternalAction {
    void logData(String dataToLog);
}
