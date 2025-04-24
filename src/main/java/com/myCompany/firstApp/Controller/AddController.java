package com.myCompany.firstApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AddController {

	  @GetMapping("/add")
	    public int add(@RequestParam int val1, @RequestParam int val2) {
	        return val1 + val2;
	    }
}
