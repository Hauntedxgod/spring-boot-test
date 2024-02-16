package ru.maxima.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Value("${hello}")
    private String hello;
    @GetMapping
    public String hello(){
        System.out.println(hello);
        return "hello";
    }
}
