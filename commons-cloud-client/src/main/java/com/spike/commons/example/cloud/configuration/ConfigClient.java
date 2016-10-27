package com.spike.commons.example.cloud.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// 配置项见: bootstrap.properties
@Configuration
@EnableAutoConfiguration
@RestController
public class ConfigClient {

  @Value("${config.name:NONE}")
  private String name = "World";

  @Value("${info.foo:NONE}")
  private String remoteConfigValue;

  @RequestMapping("/")
  public String home() {
    return "Hello " + name + ", " + remoteConfigValue;
  }

  public static void main(String[] args) {
    SpringApplication.run(ConfigClient.class, args);
  }

}