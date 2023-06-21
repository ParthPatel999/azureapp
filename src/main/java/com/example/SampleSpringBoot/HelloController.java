package com.example.SampleSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.spring.cloud.feature.management.FeatureManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {

  @Autowired FeatureManager featureManager;
  
  ObjectMapper map = new ObjectMapper();

  @GetMapping("/welcome")
  public String testAppConfiguration() throws JsonProcessingException {
    
    log.info("featureManager::" + map.writeValueAsString(featureManager));
    log.info(
        "featureManager getAllFeatureNames::"
            + map.writeValueAsString(featureManager.getAllFeatureNames()));
    
    if (featureManager.isEnabledAsync("test").block()) {
      return "Welcome!";
    } else {
      return "Not Welcome!!!";
    }
  }
}
