package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import core.model.Contact;
import core.service.ContactService;

@RestController
public class ContactRESTController {
	
	@Autowired
	ContactService service;
	

//	example of a call: http://localhost:8080/SpringRestDemo-0.0.1-SNAPSHOT/contacts?page=3&count=2
	
	  @RequestMapping(value="/contacts", method=RequestMethod.GET, produces="application/json")
	  public List<Contact> page(
	      @RequestParam(value="page", defaultValue=Integer.MAX_VALUE+"") int page,
	      @RequestParam(value="count", defaultValue="20") int count) {
	    return service.page(page, count);
	  }
	  
	  @RequestMapping(value="/contact/{id}", method=RequestMethod.GET, produces="application/json")
	  public Contact spittleById(@PathVariable Long id) {
	    return service.findById(id);
	  }
	  
	  @RequestMapping(value="/contacts/all", method=RequestMethod.GET, produces="application/json")
	  public List<Contact> all() {
	    return service.findAll();
	  }
	  
	  
	  /*
	   * In postman create a POST request to http://localhost:8080/SpringRestDemo-0.0.1-SNAPSHOT/contact
	   * click on 'body', 'raw' and add JSON: {"name" : "anna"}
	   * in headers add key: Content-Type and value: {"Content-Type":"application/json"}
	   * click 'send'
	   */
	  @RequestMapping(value="/contact",method=RequestMethod.POST, consumes="application/json")
	  public Contact saveSpittle(@RequestBody Contact contact) {
	    return service.save(contact);

	  }



}
