package com.brightstar.http.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {



    @GetMapping(value = "/cities")
    public String getCities() {


        return "cities";
    }
    
    
    @GetMapping(value = "/home")
    public String gethome() {


        return "home";
    }
    
    
    @GetMapping(value = "/timeout")
    public String gettimeout(@RequestParam(name = "second") String second) {

    	try {
			Thread.sleep(Integer.parseInt(second)*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "suspend "+second+" seconds";
    }
}