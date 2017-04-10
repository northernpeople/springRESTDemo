package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class First {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(){
		System.out.println("\n\ncontroller called\n\n");
		return "hello";
	}

}
