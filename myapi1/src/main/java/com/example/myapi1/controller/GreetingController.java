package com.example.myapi1.controller;

import org.springframework.web.bind.annotation.*;
import com.example.myapi1.model.Greeting;

@RestController
@RequestMapping("/api")
public class GreetingController {

    @GetMapping("/greet/{name}")
    public Greeting greetPath(@PathVariable String name) {
        return new Greeting("Hola, " + name + "!");
    }

    @GetMapping("/greet")
    public Greeting greetQuery(@RequestParam(value = "name", defaultValue = "mundo") String name) {
        return new Greeting("Hola, " + name + "!");
    }
}
