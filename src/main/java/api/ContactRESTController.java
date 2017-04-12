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
@RequestMapping("/contacts")
public class ContactRESTController {
	
	@Autowired
	ContactService service;
	
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";

//	@RequestMapping(method=RequestMethod.GET, produces="application/json")
//	  public List<Contact> spittles(
//	      @RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
//	      @RequestParam(value="count", defaultValue="20") int count) {
//	    return service.findSpittles(max, count);
//	  }
	  
	  @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
	  public Contact spittleById(@PathVariable Long id) {
	    return service.findById(id);
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
//	  
//	  @ExceptionHandler(SpittleNotFoundException.class)
//	  @ResponseStatus(HttpStatus.NOT_FOUND)
//	  public @ResponseBody Error spittleNotFound(SpittleNotFoundException e) {
//	    long spittleId = e.getSpittleId();
//	    return new Error(4, "Spittle [" + spittleId + "] not found");
//	  }


}
