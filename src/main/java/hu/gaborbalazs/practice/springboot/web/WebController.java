package hu.gaborbalazs.practice.springboot.web;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

	@Autowired
	private Logger logger;
	
	@RequestMapping("/greeting")
	public String getGreeting() {
		logger.info(">> getGreeting()");
		return "Hello World";
	}
}
