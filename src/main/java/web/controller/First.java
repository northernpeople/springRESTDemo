package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class First {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(){
		return "hello";
	}
	
	
	@RequestMapping(value = "/2", method = RequestMethod.GET)
	public String hello2(){
		return "templates/hello";
	}

}
