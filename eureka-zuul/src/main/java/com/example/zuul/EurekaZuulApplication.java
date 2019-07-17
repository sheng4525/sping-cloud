package com.example.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 这里用了 	@SpringCloudApplication	 注解,之前没有提过,通过源码我们看到,它整合了 
 * @SpringBootApplication	、@EnableDiscoveryClient	 、@EnableCircuitBreaker		
 * 
 * @author pengsheng
 *
 */
@EnableZuulProxy //网关
@SpringCloudApplication
public class EurekaZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaZuulApplication.class, args);
	}

}
