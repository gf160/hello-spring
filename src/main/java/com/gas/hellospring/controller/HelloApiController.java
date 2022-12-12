package com.gas.hellospring.controller;

import com.gas.hellospring.dto.HelloDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloApiController {

    @GetMapping("hello-api")
    @ResponseBody
    public HelloDto helloApi(@RequestParam("name") String name){
        HelloDto hello = new HelloDto();
        hello.setName(name);
        return hello;
    }
}

