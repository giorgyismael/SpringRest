package com.springrest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.adapter.ObjectAdapter;
import com.springrest.data.entity.PersonBO;
import com.springrest.data.vo.PersonHATEOAS;
import com.springrest.data.vo.PersonVO;
import com.springrest.exception.ResourceNotFoundExceprion;
import com.springrest.repository.PersonRepository;



@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	public PersonBO findByIdOld(Long id) {
		return personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceprion("No record found for this ID"));
	}
	
	public PersonVO findById(Long id) {
		PersonBO person =  personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceprion("No record found for this ID"));
		return ObjectAdapter.parseObject(person, PersonVO.class);
	}
	
	public PersonHATEOAS findByIdHateoas(Long id) {
		PersonBO person =  personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceprion("No record found for this ID"));
		return ObjectAdapter.parseObject(person, PersonHATEOAS.class);
	}
	
	public PersonBO saveOld(PersonBO person) {
		return personRepository.save(person);

	}
	
	public PersonVO  save(PersonVO personVO) {
		PersonBO person = ObjectAdapter.parseObject(personVO, PersonBO.class);
		return ObjectAdapter.parseObject(
				personRepository.save(person), PersonVO.class);

	}
	
	public PersonHATEOAS  saveHateoas(PersonHATEOAS personHATEOAS) {
		PersonBO person = ObjectAdapter.parseObject(personHATEOAS, PersonBO.class);
		return ObjectAdapter.parseObject(
				personRepository.save(person), PersonHATEOAS.class);

	}
	
	public PersonVO  update(PersonVO person) {
		PersonVO currentPerson = findById(person.getId_person());
		currentPerson.setFirstName(person.getFirstName());
		currentPerson.setGender(person.getGender());
		currentPerson.setAddress(person.getAddress());
		return ObjectAdapter.parseObject(
				save(currentPerson), PersonVO.class);
	}
	
	public PersonHATEOAS  updateHateas(PersonHATEOAS person) {
		PersonHATEOAS currentPerson = findByIdHateoas(person.getKey());
		currentPerson.setFirstName(person.getFirstName());
		currentPerson.setGender(person.getGender());
		currentPerson.setAddress(person.getAddress());
		return ObjectAdapter.parseObject(
				saveHateoas(currentPerson), PersonHATEOAS.class);
	}
	
	public PersonBO  updateOld(PersonBO person) {
		PersonBO currentPerson = findByIdOld(person.getId_person());
		currentPerson.setFirstName(person.getFirstName());
		currentPerson.setGender(person.getGender());
		currentPerson.setAddress(person.getAddress());
		return saveOld(currentPerson);
	}
	
	public void delete(Long id) {
		PersonBO currentPerson = findByIdOld(id);
		personRepository.delete(currentPerson);
	}
	
	public List<PersonVO> findAll() {
		return ObjectAdapter.parseObjects(
				personRepository.findAll(), PersonVO.class);
	}
	
	public List<PersonHATEOAS> findAllHateoas() {
		return ObjectAdapter.parseObjects(
				personRepository.findAll(), PersonHATEOAS.class);
	}
	
	public List<PersonBO> findAllOld() {
		return personRepository.findAll();
	}


}
