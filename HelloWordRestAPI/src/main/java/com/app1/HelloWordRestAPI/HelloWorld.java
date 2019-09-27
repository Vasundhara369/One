package com.app1.HelloWordRestAPI;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
    HelloWorld()
    {

    }
    String greet(String name)
    {
        return "Hello "+name;
    }
}
