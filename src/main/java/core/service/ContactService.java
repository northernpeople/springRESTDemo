package core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.model.Contact;
import core.model.ContactRepo;

@Service
public class ContactService {
	
	private ContactRepo repo;

	@Autowired
	public ContactService(ContactRepo repo) { this.repo = repo; }
	
	
	public Contact save(Contact c){
		return repo.saveAndFlush(c);
	}
	
	public List<Contact> findAll(){
		return repo.findAll();
	}

}
