package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.data.entity.PersonBO;
import com.springrest.service.PersonService;

@RestController
@RequestMapping("/person/v2")
public class PersonControlerV2 {
	
	@Autowired
	PersonService personService;
	
    @RequestMapping(
    			value="/{id}", 
    			method= RequestMethod.GET, 
    			produces=MediaType.APPLICATION_JSON_VALUE)
    public PersonBO findByID(@PathVariable("id") Long id) {
    	return personService.findByIdOld(id);
    }
    
    @RequestMapping(
			method= RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
    public PersonBO create(@RequestBody PersonBO person) {
    	return personService.saveOld(person);	
    }
    
    
    @RequestMapping(
			method= RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
    public PersonBO update(@RequestBody PersonBO person) {
    	return personService.updateOld(person);	
    }
    
    @RequestMapping(
    		value="/{id}",
			method= RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Long id) {
    	personService.delete(id);	
    }
    
    @RequestMapping(
			method= RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
    public List<PersonBO> findAll() {
    	return personService.findAllOld();
    }


}
