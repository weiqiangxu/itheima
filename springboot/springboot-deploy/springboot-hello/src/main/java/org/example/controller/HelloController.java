package org.example.controller;

import com.example.App;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/get")
    @ResponseBody
    public Integer Get() {
        return App.add(1,2);
    }
}
