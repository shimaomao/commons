package com.spike.commons.example.cloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {
  private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfig.class);

  @Bean
  public RestTemplate restTemplate() {
    LOG.info("init RestTemplate...");
    RestTemplate result = new RestTemplate();
    return result;
  }
}
