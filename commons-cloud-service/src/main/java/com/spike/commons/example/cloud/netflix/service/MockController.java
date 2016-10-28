package com.spike.commons.example.cloud.netflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

  @Autowired
  private MockService mockService;

  @RequestMapping(path = { "/mock" }, method = { RequestMethod.POST })
  public @ResponseBody String mock(@RequestBody String param) {
    if (param == null || "".equals(param.trim())) {
      param = "NULL";
    }
    return param;
  }

}
