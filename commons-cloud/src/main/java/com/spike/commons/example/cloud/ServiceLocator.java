package com.spike.commons.example.cloud;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class ServiceLocator {

  private static final Logger LOG = LoggerFactory.getLogger(ServiceLocator.class);

  @Autowired
  private DiscoveryClient discoveryClient;

  // 打印所有服务
  public void rendererAllService() {
    LOG.info("Description: {}", discoveryClient.description());

    List<String> serviceIds = discoveryClient.getServices();
    LOG.info("All Services: {}", serviceIds);

    for (String serviceId : serviceIds) {
      LOG.info("Service {}", discoveryClient.getInstances(serviceId));
    }
  }
}
