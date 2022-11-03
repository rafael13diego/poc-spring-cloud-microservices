package com.drafael.professional.drafaeldbz.controllers;

import com.drafael.professional.drafaeldbz.config.DragonBallConfig;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Random;

@RestController
@RequestMapping("/example")
@Slf4j
public class ExampleController {

    @Autowired
    private DragonBallConfig configuration;

    @Autowired
    private MeterRegistry registry;

    @GetMapping
    @Timed("drafael.dbz.name.get")
    public ResponseEntity<String> getNameApplication(){
        log.info("Getting application name");
        int value = new Random().nextInt(5);
        registry.counter("drafael.dbz.name","level",(value<3) ? "jr" : "Senior").increment(value);
        if (value<3){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(configuration.getApplicationName());
    }
}