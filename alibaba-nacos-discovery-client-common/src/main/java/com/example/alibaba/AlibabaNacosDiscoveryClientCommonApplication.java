package com.example.alibaba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients 
public class AlibabaNacosDiscoveryClientCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlibabaNacosDiscoveryClientCommonApplication.class, args);
	}
	
	@Slf4j
    @RestController
    static class TestController {

        @Autowired
        LoadBalancerClient loadBalancerClient;
        
        /**
         * 方法1，原始调用
         * @return
         */
//        @GetMapping("/test")
//        public String test() {
//            // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
//            ServiceInstance serviceInstance = loadBalancerClient.choose("alibaba-nacos-discovery-service");
//            String url = serviceInstance.getUri() + "/hello?name=" + "didi";
//            RestTemplate restTemplate = new RestTemplate();
//            String result = restTemplate.getForObject(url, String.class);
//            return "spring cloud common==》Invoke : " + url + ", return : " + result;
//        }
        
        @Autowired
        RestTemplate restTemplate;
        
        /**
         * 方法2 RestTemplate的负载均衡的调用
         * @return
         */
//        @GetMapping("/test")
//        public String test() {
//        	String result = restTemplate.getForObject("http://alibaba-nacos-discovery-service/hello?name=didi", String.class);
//            return "RestTemplate==》Return : " + result;
//        }
        
        /**
         * 添加@LoadBalanced注解，@LoadBalanced，Spring Cloud会将请求拦截下来，然后通过负载均衡器选出节点，从而实现基于服务名的负载均衡调用
         * @return
         */
        @Bean
        @LoadBalanced
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
        
        
        @Autowired
        Client client;
        
        /**
         * 方法3 Feign负载均衡的调用
         * @return
         */
        @GetMapping("/test")
        public String test() {
            String result = client.hello("didi");
            return "Feign===》Return : " + result;
        }
        
        @FeignClient("alibaba-nacos-discovery-service")
        interface Client {

            @GetMapping("/hello")
            String hello(@RequestParam(name = "name") String name);

        }
        
        
    }

}