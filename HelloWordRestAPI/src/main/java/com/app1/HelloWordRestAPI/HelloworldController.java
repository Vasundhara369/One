package com.app1.HelloWordRestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloworldController {
    @Autowired
    HelloWorld h;
   /* @RequestMapping("/sayHello")
    public String sayHello(@RequestParam(value="name")String name)
    {

        return h.greet(name);
    }*/
    @RequestMapping(value="/sayHello",method = RequestMethod.POST)//,headers="Accept=application/json")
    public String sayHello(@RequestBody Map<String,Object> name) throws Exception
    {
        System.out.println(name);
        //return h.greet(name);
        return "n";
    }
}
