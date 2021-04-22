package com.springrest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.springrest.data.vo.PersonHATEOAS;
import com.springrest.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Person Controler V4", description="Descrição de funcionalmento do PersonControler", tags = {"PersonControler"}) 
@RestController
@RequestMapping("/api/person/v4")
public class PersonControlerV4 {
	
	@Autowired
	PersonService personService;
	
	@Autowired
	ObjectAdapter personAdapter;
	@ApiOperation(value = "Find all Persons" )
	@GetMapping(produces = { "application/json", "application/xml",  "application/x-yaml"})
	public List<PersonHATEOAS> findAll() {
		List<PersonHATEOAS> persons = personService.findAllHateoas();		
		persons.stream()
				.forEach(person -> 
					person.add(linkTo(methodOn(PersonControlerV4.class)
							.findById(person.getKey()))
							.withSelfRel()));
		return persons;
	}
	@ApiOperation(value = "Find a specific Person by your ID" )
	@GetMapping(value="/{id}", produces = {"application/json", "application/xml",  "application/x-yaml"})
    public PersonHATEOAS findById(@PathVariable("id") Long id) {
		PersonHATEOAS person = personService.findByIdHateoas(id);
		person.add(linkTo(methodOn(PersonControlerV4.class).findById(id)).withSelfRel());
		return person;
    }
	@ApiOperation(value = "Create a new Person")
    @PostMapping(produces = {"application/json", "application/xml",  "application/x-yaml"}, 
    		consumes= {"application/json", "application/xml",  "application/x-yaml"})
    public PersonHATEOAS create(@RequestBody PersonHATEOAS person) {
    	PersonHATEOAS personHateoas = personService.saveHateoas(person);
    	personHateoas.add(linkTo(methodOn(PersonControlerV4.class).findById(personHateoas.getKey())).withSelfRel());
    	return 	personHateoas;
    }
	@ApiOperation(value = "Update Person by your ID")
    @PutMapping(produces = {"application/json", "application/xml",  "application/x-yaml"}, 
    		consumes= {"application/json", "application/xml",  "application/x-yaml"})
    public PersonHATEOAS update(@RequestBody PersonHATEOAS person) {
    	PersonHATEOAS personHateoas = personService.updateHateas(person);
    	personHateoas.add(linkTo(methodOn(PersonControlerV4.class).findById(personHateoas.getKey())).withSelfRel());
    	return 	personHateoas;
    }
	@ApiOperation(value = "Delete Person by your ID")
    @DeleteMapping(value="/{id}")	
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    	personService.delete(id);	
    	return ResponseEntity.ok().build();
    }
}
