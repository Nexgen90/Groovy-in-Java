package com.example.groovy.actions.http;

import com.example.groovy.actions.ExternalAction;

/**
 * Created by nikolay.mikutskiy
 * Date: 26.01.2021
 */
public interface HttpAction extends ExternalAction {
    String getUrl();
}
