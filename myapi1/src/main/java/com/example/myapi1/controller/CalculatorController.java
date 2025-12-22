package com.example.myapi1.controller;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class CalculatorController {

    @GetMapping("/add/{a}/{b}")
    public int addPath(@PathVariable int a, @PathVariable int b) {
        return a+b;
    }

    @GetMapping("/add")
    public int addQuery(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
        return a + b;
    }

    @GetMapping("/subtract/{a}/{b}")
    public int subtractPath(@PathVariable int a, @PathVariable int b) {
        return a - b;
    }

    @GetMapping("/subtract")
    public int subtractQuery(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
        return a - b;
    }

    @GetMapping("/multiply/{a}/{b}")
    public int multiplyPath(@PathVariable int a, @PathVariable int b) {
        return a * b;
    }

    @GetMapping("/multiply")
    public int multiplyQuery(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
        return a * b;
    }

}

