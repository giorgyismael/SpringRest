package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Consumer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.adapter.ObjectAdapter;
import com.springrest.data.vo.PersonVO;
import com.springrest.service.PersonService;

@RestController
@RequestMapping("/api/person/v3")
public class PersonControlerV3 {
	
	@Autowired
	PersonService personService;
	
	@Autowired
	ObjectAdapter personAdapter;
	
	@GetMapping(produces = { "application/json", "application/xml",  "application/x-yaml"})
	public List<PersonVO> findAll() {
		return personService.findAll();
	}

	@GetMapping(value="/{id}", produces = {"application/json", "application/xml",  "application/x-yaml"})
    public PersonVO findByID(@PathVariable("id") Long id) {
    	return personService.findById(id);
    }
    
    @PostMapping(produces = {"application/json", "application/xml",  "application/x-yaml"}, 
    		consumes= {"application/json", "application/xml",  "application/x-yaml"})
    public PersonVO create(@RequestBody PersonVO person) {
    	return personService.save(person);	
    }
    
    @PutMapping(produces = {"application/json", "application/xml",  "application/x-yaml"}, 
    		consumes= {"application/json", "application/xml",  "application/x-yaml"})
    public PersonVO update(@RequestBody PersonVO person) {
    	return personService.update(person);	
    }
    
    @DeleteMapping(value="/{id}")	
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    	personService.delete(id);	
    	return ResponseEntity.ok().build();
    }
}
