package cn.tedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	@Autowired
	
	private RestTemplate restTemplate;
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name){
		String url="http://provider-user:7900/hello/"+name;
		return restTemplate.getForObject(url, String.class);
	}
}
