package com.example.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.feign.service.FeignServiceClient;

@RestController
public class FeignController {

	@Autowired
	FeignServiceClient feignServiceClient;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add() {
		return feignServiceClient.add(10, 20);
	}
}
