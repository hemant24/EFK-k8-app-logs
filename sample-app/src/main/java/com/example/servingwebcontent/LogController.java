package com.example.servingwebcontent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogController {


  @GetMapping("/log")
  public void create(@RequestParam(name="level", required=false, defaultValue="info") String level) {
    if("error".equals(level)){
      Exception e = new RuntimeException("This is just dummy excpetion");
      log.error("Error while executing statement {} ", e);
    }
    log.info("this is info message");
    log.warn("this is warn message");
  }
}
