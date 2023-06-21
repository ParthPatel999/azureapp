package com.example.SampleSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.spring.cloud.feature.management.FeatureManager;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class HelloController {

  @Autowired FeatureManager featureManager;

  @GetMapping("/welcome")
  public String testAppConfiguration() throws JsonProcessingException {
    
    if (featureManager.isEnabledAsync("test").block()) {
      return "Welcome!";
    } else {
      return "Not Welcome!!!";
    }
  }
}
