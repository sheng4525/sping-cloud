package com.example.feign.service;

/**
 * 方法验证一下,是否在compute-service服务不可用的情况下,⻚面返回了-9999
 * @author pengsheng
 *
 */
public class ComputeClientHystrix implements FeignServiceClient {

	@Override
	public Integer add(Integer a, Integer b) {
		return -99999;
	}

}
