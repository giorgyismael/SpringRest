package com.springrest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.adapter.PersonAdapter;
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
		return PersonAdapter.parseObject(person, PersonVO.class);
	}
	
	public PersonHATEOAS findByIdHateoas(Long id) {
		PersonBO person =  personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceprion("No record found for this ID"));
		return PersonAdapter.parseObject(person, PersonHATEOAS.class);
	}
	
	public PersonBO saveOld(PersonBO person) {
		return personRepository.save(person);

	}
	
	public PersonVO  save(PersonVO personVO) {
		PersonBO person = PersonAdapter.parseObject(personVO, PersonBO.class);
		return PersonAdapter.parseObject(
				personRepository.save(person), PersonVO.class);

	}
	
	public PersonHATEOAS  saveHateoas(PersonHATEOAS personHATEOAS) {
		PersonBO person = PersonAdapter.parseObject(personHATEOAS, PersonBO.class);
		return PersonAdapter.parseObject(
				personRepository.save(person), PersonHATEOAS.class);

	}
	
	public PersonVO  update(PersonVO person) {
		PersonVO currentPerson = findById(person.getId_person());
		currentPerson.setFirstName(person.getFirstName());
		currentPerson.setGender(person.getGender());
		currentPerson.setAddress(person.getAddress());
		return PersonAdapter.parseObject(
				save(currentPerson), PersonVO.class);
	}
	
	public PersonHATEOAS  updateHateas(PersonHATEOAS person) {
		PersonHATEOAS currentPerson = findByIdHateoas(person.getKey());
		currentPerson.setFirstName(person.getFirstName());
		currentPerson.setGender(person.getGender());
		currentPerson.setAddress(person.getAddress());
		return PersonAdapter.parseObject(
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
		return PersonAdapter.parseObjects(
				personRepository.findAll(), PersonVO.class);
	}
	
	public List<PersonHATEOAS> findAllHateoas() {
		return PersonAdapter.parseObjects(
				personRepository.findAll(), PersonHATEOAS.class);
	}
	
	public List<PersonBO> findAllOld() {
		return personRepository.findAll();
	}


}
