package com.example.servingwebcontent;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	private Counter greetingCounter = Metrics.counter("handler.calls", "uri", "/greeting");

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		greetingCounter.increment();
		model.addAttribute("name", name);
		return "greeting";
	}

}
