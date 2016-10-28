package com.spike.commons.example.cloud.netflix;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
public class NetflixServerApplication {

  public static void main(String[] args) {
    new SpringApplicationBuilder(NetflixServerApplication.class).web(true).run(args);
  }
}