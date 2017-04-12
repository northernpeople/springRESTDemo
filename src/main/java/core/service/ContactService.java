package core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import core.model.Contact;
import core.model.ContactRepo;

@Service
public class ContactService {
	
	private ContactRepo repo;

	@Autowired
	public ContactService(ContactRepo repo) { this.repo = repo; }
	
	public List<Contact> page(int page, int count){
		return repo.findAll(new PageRequest(page, count)).getContent();
	}
	
	
	public Contact save(Contact c){
		return repo.saveAndFlush(c);
	}
	
	public Contact findById(Long id){
		return repo.findOne(id);
	}
	
	public List<Contact> findAll(){
		return repo.findAll();
	}

}
