package com.example.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConsumerService {
	
	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * 
	 *  依次启动eureka-server、compute-service、eureka-ribbon工程
		访问http://localhost:1111/可以看到注册中心的状态
		访问http://localhost:3333/add,⻚面显示:30
		关闭compute-service服务后再访问http://localhost:3333/add,⻚面显示:error
	 * @return
	 */
	@HystrixCommand(fallbackMethod	=	"addServiceFallback")
	public	String	consumerAdd()	{
		return	restTemplate.getForEntity("http://eureka-service/add?a=10&b=20",String.class).getBody();
	}
	
	
	public String addServiceFallback() {
		return "error";
	}
}	
