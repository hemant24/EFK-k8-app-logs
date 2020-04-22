package com.example.servingwebcontent;

import com.example.servingwebcontent.RestGreetingController.Greeting;
import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyObjectController {

  ArrayList<DummyClass> dummyObjects = new ArrayList<>();

  @GetMapping("/dummy/create")
  public void create(@RequestParam(name="count", required=false, defaultValue="1000") int count) {
    //To make it 400 MB, i have to create  1000 * 1000 objects ( 40 bytes is size of class)


    for (int i = 0; i < count; i++) {
      dummyObjects.add(new DummyClass());
    }
    System.out.println("done creating current size is " + dummyObjects.size() );
  }

  @GetMapping("/dummy/delete")
  public void delete(@RequestParam(name="count", required=false, defaultValue="1000") int count) {
    //To make it 400 MB, i have to create 40 * 1000 * 1000 objects


    for (int i = 0; i < count; i++) {
      dummyObjects.remove(i);
    }
    System.out.println("done creating current size is " + dummyObjects.size() );
  }


}
