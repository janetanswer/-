package com.brightstar.http.server.controller.post;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/brightstar")
public class PostController {
	
	
    @RequestMapping(value = "/hello.post", method = RequestMethod.POST)
    public String helloPost(@RequestParam(name = "name") String name) {
        System.out.println("server->http.post:" + name);
        return "hello " + name;
    }

}
