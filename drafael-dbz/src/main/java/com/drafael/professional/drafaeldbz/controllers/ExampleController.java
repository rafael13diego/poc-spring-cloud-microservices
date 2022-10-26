package com.drafael.professional.drafaeldbz.controllers;

import com.drafael.professional.drafaeldbz.config.DragonBallConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@Slf4j
public class ExampleController {

    @Autowired
    private DragonBallConfig configuration;

    @GetMapping
    public ResponseEntity<String> getNameApplication(){
        log.info("Getting application name");
        return ResponseEntity.ok(configuration.getApplicationName());
    }
}