package com.spike.commons.example.cloud.netflix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @see EurekaInstanceConfigBean
 * @see EurekaClientConfigBean
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class NetflixClientApplication {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private NetflixServiceLocator serviceLocator;

  @RequestMapping("/")
  public String home() {
    return "Hello World: " + serviceLocator.serviceUrl();
  }

  public static void main(String[] args) {
    SpringApplication.run(NetflixClientApplication.class, args);

  }

}