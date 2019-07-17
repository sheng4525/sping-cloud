package com.example.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 访问地址：http://127.0.0.1:8848/nacos/ 发现服务
 * @author pengsheng
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaNacosDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlibabaNacosDiscoveryServerApplication.class, args);
	}
	
	@Slf4j
    @RestController
    static class TestController {
        @GetMapping("/hello")
        public String hello(@RequestParam String name) {
            log.info("invoked name = " + name);
            return "hello " + name;
        }
    }

}
