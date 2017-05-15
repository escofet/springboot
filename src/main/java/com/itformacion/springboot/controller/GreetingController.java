package com.itformacion.springboot.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.itformacion.springboot.model.Greeting;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
    @RequestMapping(value = "nongreeting", method = RequestMethod.POST )
    public Greeting nongreeting(String name) {
        return new Greeting(counter.incrementAndGet(), "Not welcome");
    }
    
    @RequestMapping(value = "{ident}", method = RequestMethod.GET)
    public String getid(@PathVariable("ident") String ident) {
        return "This is the identifier " + ident;
    }
}