package com.brightstar.http.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpServer {

	@RequestMapping(value = "/hello.get", method = RequestMethod.GET)
    public String hello(@RequestParam(name = "name") String name) {
        System.out.println("server->http.get:" + name);
        return "hello " + name;
    }

    @RequestMapping(value = "/hello.post", method = RequestMethod.POST)
    public String helloPost(@RequestParam(name = "name") String name) {
        System.out.println("server->http.post:" + name);
        return "hello " + name;
    }

}
