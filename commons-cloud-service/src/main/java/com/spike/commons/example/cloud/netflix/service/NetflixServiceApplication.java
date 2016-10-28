package com.spike.commons.example.cloud.netflix.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NetflixServiceApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(NetflixServiceApplication.class).web(true).run(args);
  }
}
