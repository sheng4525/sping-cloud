package com.example.alibaba;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 用curl或者postman等工具，访问接口: localhost:8600/test，一切正常的话，将返回Nacos中配置的spring-cloud-alibaba-learning。
 * 然后，再通过Nacos页面，修改这个内容，点击发布之后，再访问接口，可以看到返回结果变了
 * 
 * 通过后续了解，SpringCloudConfig和 NacosConfig这种统一配置服务在springboot项目中初始化时，都是加载bootstrap.properties配置文件去初始化上下文。
 * 这是由spring boot的加载属性文件的优先级决定的，想要在加载属性之前去config server上取配置文件，那NacosConfig或SpringCloudConfig相关配置就是需要最先加载的，而bootstrap.properties的加载是先于application.properties的，所以config client要配置config的相关配置就只能写到bootstrap.properties里了
 * @author pengsheng
 *
 */
@SpringBootApplication
public class AlibabaNacosConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlibabaNacosConfigClientApplication.class, args);
	}
	
	@Slf4j
    @RestController
    @RefreshScope
    static class TestController {

        @Value("${didispace.title:}")
        private String title;
        
        @Value("${didispace.content:}")
        private String content;
        

        @GetMapping("/test")
        public String hello() {
            return title + content;
        }

    }

}
