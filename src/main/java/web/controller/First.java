package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import core.model.Contact;
import core.service.ContactService;

@Controller
public class First {
	
	
	@Autowired
	ContactService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(Model m){
		m.addAttribute("contacts", service.findAll());
		m.addAttribute("contact", new Contact());
		return "hello";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Contact contact, Model m){
		service.save(contact);
		System.out.println(".. contact: "+contact);
		return "redirect:/";
	}

}
