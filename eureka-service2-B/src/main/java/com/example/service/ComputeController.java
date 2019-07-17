package com.example.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 消费者服务
 * @author pengsheng
 *
 */
@RestController
public class ComputeController {
	private	final Logger logger =	LoggerFactory.getLogger(ComputeController.class);
	
	
	@Autowired
	private DiscoveryClient client;
	

	@RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        List<ServiceInstance> instances = client.getInstances("eureka-service");
        Integer r = a + b;
        for (ServiceInstance instance : instances) {
        	 logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
		}
        return r;
    }
}
