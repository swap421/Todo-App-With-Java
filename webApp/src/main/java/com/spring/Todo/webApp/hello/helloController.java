package com.spring.Todo.webApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {

    @RequestMapping("hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Java Developer";
    }
    @RequestMapping("say-hello-jsp")
    public String sayHelloJSP(){
        return "sayHello";
    }
}
