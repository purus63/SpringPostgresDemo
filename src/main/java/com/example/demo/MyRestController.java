package com.example.demo;

import java.sql.Timestamp;
import java.util.Optional;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PostGresRepo;

@RestController
@RequestMapping("/v1")
public class MyRestController {

	
	@Autowired
	PostGresRepo pg;
	
    @RequestMapping(value = "/getapi", method = RequestMethod.GET)
    public String getcall() {

		long t1 = System.currentTimeMillis();
		Optional<User> u = pg.findById(4);
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		return u.get().toString();
    }
}