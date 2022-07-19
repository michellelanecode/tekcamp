package com.teksystems.bootcamp.springboot.movierental.helloworld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//controller that handles rest requests
@RestController
public class HelloWorldController {

    //Get
    //uri - /hello-world
    //method should return hello world

    //how to map a get a request to the uri
    //insert the request method
    //map to uri using path
    @GetMapping(path = "/sakila")
    public String helloWorld(){
        return "Hello World This Is Working";
    }
    //hello-world-bean return
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World Bean");
    }
}


