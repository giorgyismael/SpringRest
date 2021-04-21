package com.springrest.controller;

import org.springframework.web.bind.annotation.*;

import com.springrest.data.entity.GreetingBO;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingControler {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public GreetingBO greting(@RequestParam(value="name", defaultValue = "World") String name) {
        return new GreetingBO(counter.incrementAndGet(), String.format(template, name));
    }
}
