package model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.CoreConfiguration;
import service.ContactService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CoreConfiguration.class)
public class ContactRepoTest {

	@Autowired
	ContactService service;

	@Test
	public void shouldInject(){
		assertNotNull(service);
	}
	
	@Test
	public void shouldSave(){
		Contact contact = new Contact("Ronathan");
		service.save(contact);
		assertTrue(service.findAll().contains(contact));
		
	}
	
	
}
