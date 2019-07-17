package com.example.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 创建ConsumerController来消费eureka-service的add服务。通过直接RestTemplate来调用服务,计算10	+20的值
 * @author pengsheng
 *
 */
@RestController
public class ConsumerController {
	
	@Autowired
	ConsumerService consumerService;
	
	@RequestMapping(value	=	"/add",	method	= RequestMethod.GET)
	public	String	add()	{
		return	consumerService.consumerAdd();
	}
}
