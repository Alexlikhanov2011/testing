package com.example.testirovanie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculateController {
    private final CalculateService service;

    public CalculateController(CalculateService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String hello() {
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping("/plus")
    public <num1> String plus(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return num1 + " + " + num2 + " = " + service.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return num1 + " - " + num2 + " = " + service.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return num1 + " * " + num2 + " = " + service.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        try {
            return num1 + " / " + num2 + " = " + service.divide(num1, num2);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Деление на 0 не возможно!");
        }
    }
}
