package com.spike.commons.example.cloud.netflix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

// 服务定位器
@Component
public class NetflixServiceLocator {

  private static final Logger LOG = LoggerFactory.getLogger(NetflixServiceLocator.class);

  @Autowired
  private EurekaClient eurekaClient;

  @Autowired
  private DiscoveryClient discoveryClient;

  @Autowired
  private RestTemplate restTemplate;

  public String serviceUrl() {
    // 服务发现
    LOG.info("Services: {}", discoveryClient.getServices());
    List<ServiceInstance> list = discoveryClient.getInstances("cloud-service");
    LOG.info("cloud-service instances: {}", list);
    if (list == null || list.size() == 0) {
      return "NULL";
    }

    // 调用服务
    String requestUrl = list.get(0).getUri().toString() + "/mock";
    Map<String, Object> urlVariables = new HashMap<String, Object>();
    String serviceResult =
        restTemplate.postForObject(requestUrl, "hello", String.class, urlVariables);

    return requestUrl + "; result=" + serviceResult;
  }

}
