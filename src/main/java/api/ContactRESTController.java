package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	  
	  @RequestMapping(value="contact/{id}", method=RequestMethod.GET, produces="application/json")
	  public Contact spittleById(@PathVariable Long id) {
	    return service.findById(id);
	  }
	  
	  @RequestMapping(value="/contacts/all", method=RequestMethod.GET, produces="application/json")
	  public List<Contact> all() {
	    return service.findAll();
	  }
	  
//	  @RequestMapping(method=RequestMethod.POST, consumes="application/json")
//	  @ResponseStatus(HttpStatus.CREATED)
//	  public ResponseEntity<Spittle> saveSpittle(@RequestBody Spittle spittle, UriComponentsBuilder ucb) {
//	    Spittle saved = spittleRepository.save(spittle);
//	    
//	    HttpHeaders headers = new HttpHeaders();
//	    URI locationUri = ucb.path("/spittles/")
//	        .path(String.valueOf(saved.getId()))
//	        .build()
//	        .toUri();
//	    headers.setLocation(locationUri);
//	    
//	    ResponseEntity<Spittle> responseEntity = new ResponseEntity<Spittle>(saved, headers, HttpStatus.CREATED);
//	    return responseEntity;
//	  }



}
