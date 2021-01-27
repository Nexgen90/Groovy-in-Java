package com.example.groovy.service;

import groovy.lang.GroovyShell;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer;
import org.codehaus.groovy.control.customizers.ImportCustomizer;
import org.springframework.stereotype.Service;

/**
 * Created by nikolay.mikutskiy
 * Date: 25.01.2021
 */
@Slf4j
@Service
public class ScriptLoader {

    private final GroovyShell groovyShell;

    public ScriptLoader() {
        CompilerConfiguration config = new CompilerConfiguration();
        ImportCustomizer importCustomizer = new ImportCustomizer();
        importCustomizer.addStarImports(
                "com.example.groovy.service",
                "com.example.groovy.dto",
                "com.example.groovy.actions",
                "com.example.groovy.actions.log",
                "com.example.groovy.actions.http",
                "com.example.groovy.configuration.properties");
        config.setDebug(true);
        config.setVerbose(true);
        config.addCompilationCustomizers(importCustomizer);
        config.addCompilationCustomizers(new ASTTransformationCustomizer(groovy.util.logging.Slf4j.class));
        this.groovyShell = new GroovyShell(config);
    }

    public <T> T load(String code, String script, Class<T> clazz) {
        String scriptContent = script;
        Object scriptClass;

        scriptClass = groovyShell.evaluate(scriptContent, code);

        if (clazz.isInstance(scriptClass)) {
            return (T) scriptClass;
        }

        throw new RuntimeException("Can't load my groovy script");
    }
}
