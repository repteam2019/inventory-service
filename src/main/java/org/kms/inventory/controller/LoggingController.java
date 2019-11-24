package org.kms.inventory.controller;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/logs")
public class LoggingController {

    @PostMapping("/level")
    public boolean setLogLevel(@RequestParam String level, @RequestParam  String pakage ) {
        LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();
        switch (level) {
            case "info" :
                loggerContext.getLogger(pakage).setLevel(Level.INFO);
                return true;
            case "debug":
                loggerContext.getLogger(pakage).setLevel(Level.DEBUG);
                return true;
        }
        return false;
    }

}
