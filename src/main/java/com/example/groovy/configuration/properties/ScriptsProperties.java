package com.example.groovy.configuration.properties;

import com.example.groovy.actions.ActionType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Created by nikolay.mikutskiy
 * Date: 25.01.2021
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "scripts")
public class ScriptsProperties {
    private Map<String, Action> actions;

    @Data
    public static class Action {
        private ActionType type;
        private String description;
        private String script;
    }
}
