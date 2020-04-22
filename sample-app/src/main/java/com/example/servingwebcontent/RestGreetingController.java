package com.example.servingwebcontent;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestGreetingController {

  public class Greeting {
    String greet;

    public String getGreet() {
      return greet;
    }

    public void setGreet(String greet) {
      this.greet = greet;
    }

    Greeting(String greet){
      this.greet = greet;
    }
  }

  @GetMapping("/r/greeting")
  public Greeting greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
   // waitThere();
    return new Greeting("Hello world");
  }

  @GetMapping("/u/greeting")
  public Greeting userGreeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
    // waitThere();
    return new Greeting("Hello user");
  }

  @GetMapping("/admin/greeting")
  public Greeting adminGreetings(@RequestParam(name="name", required=false, defaultValue="World") String name) {
    return new Greeting("Hello Admins");
  }


  private void waitThere(){
    try {
      System.out.println("Request is handled by thread" + Thread.currentThread().getName());
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
