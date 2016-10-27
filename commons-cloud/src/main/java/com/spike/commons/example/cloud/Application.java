package com.spike.commons.example.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// REF http://cloud.spring.io/spring-cloud-static/spring-cloud-zookeeper/1.0.3.RELEASE
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Application {

  @Autowired
  private ServiceLocator serviceLocator;

  @RequestMapping("/")
  public String home() {

    serviceLocator.rendererAllService();

    return "Hello world";
  }

  public static void main(String[] args) {
    new SpringApplicationBuilder(Application.class).web(true).run(args);
  }

}