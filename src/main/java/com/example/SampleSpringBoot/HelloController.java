package com.example.SampleSpringBoot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @RequestMapping("/getUser")
  public String hello() {
    return "Hello Parth";
  }
}
