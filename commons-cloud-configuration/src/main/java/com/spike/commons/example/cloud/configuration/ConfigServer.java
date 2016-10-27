package com.spike.commons.example.cloud.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

// REF http://cloud.spring.io/spring-cloud-static/spring-cloud-config/1.2.1.RELEASE/
//
// in Git
// application.yml
// ACCESS: http://localhost:8888/application-default.yml
//
// configServer.yml
// http://localhost:8888/configServer-default.yml
// 注意查看日志输出中的HandlerMapping {name}-{profile}
@SpringBootApplication
@EnableConfigServer
public class ConfigServer {

  public static void main(String[] args) {
    SpringApplication.run(ConfigServer.class, args);
  }

}