package com.spike.web.client;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.spike.commons.example.cloud.netflix.NetflixSupportConfig;

/**
 * {@linkplain RestTemplate}的spike测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { NetflixSupportConfig.class })
// NetflixClientApplication.class
public class RestTemplateTest {
  private static final Logger LOG = LoggerFactory.getLogger(RestTemplateTest.class);

  @Autowired
  private RestTemplate restTemplate;

  @Test
  public void resoruce() {
    Assert.assertNotNull(restTemplate);
  }

  @Test
  public void invoke() {
    // String requestUrl = "http://localhost:8890/mock?param=%1$s";
    // requestUrl = String.format(requestUrl, "hello");

    String requestUrl = "http://localhost:8890/mock";
    LOG.info("Request url: {}", requestUrl);
    Map<String, Object> urlVariables = new HashMap<String, Object>();
    String serviceResult =
        restTemplate.postForObject(requestUrl, "hello", String.class, urlVariables);
    System.err.println(serviceResult);

  }

}
