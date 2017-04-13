package api.consumer;

import java.util.Arrays;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import core.model.Contact;


/*
 * Calls service deployed on localhost. Uses RestTemplate.
 * Expects message converter bean.
 */
@Service
public class RestConsumer {
	
	private String getUrl 		= "http://localhost:8080/SpringRestDemo-0.0.1-SNAPSHOT/contact/{id}";
	private String postUrl 		= "http://localhost:8080/SpringRestDemo-0.0.1-SNAPSHOT/contact";
	private String getAllUrl 	= "http://localhost:8080/SpringRestDemo-0.0.1-SNAPSHOT/contacts/all";

	public Contact getContact(Long id){
		return new RestTemplate().getForObject(getUrl, Contact.class, id);
	}
	
	public Contact postContact(Contact c){
		return new RestTemplate().postForObject(postUrl, c, Contact.class);
	}
	
	public List<Contact> getAllContacts() {
	    Contact[] response = new RestTemplate().getForObject(getAllUrl, Contact[].class);
	    return Arrays.asList(response);
	}
	
	
	
	@Scheduled(initialDelay=10000, fixedRate=10000)
	public void testRestConsumer(){
		Contact c = new Contact("zhopa");
		Long id = postContact(c).getId();
		Contact received = getContact(id);
		System.out.println("REST recieved: " + received);
		System.out.println("REST all recieved: " + getAllContacts());

	}

}
