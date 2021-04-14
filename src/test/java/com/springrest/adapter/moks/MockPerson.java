package com.springrest.adapter.moks;

import java.util.ArrayList;
import java.util.List;

import com.springrest.data.entity.PersonBO;
import com.springrest.data.vo.PersonVO;
import com.springrest.enums.Gender;

public class MockPerson {
	
	 public PersonBO mockEntity() {
	    	return mockEntity(0);
	    }
	    
	    public PersonVO mockVO() {
	    	return mockVO(0);
	    }
	    
	    public List<PersonBO> mockEntitys() {
	        List<PersonBO> persons = new ArrayList<PersonBO>();
	        for (int i = 0; i < 14; i++) {
	            persons.add(mockEntity(i));
	        }
	        return persons;
	    }

	    public List<PersonVO> mockVOs() {
	        List<PersonVO> persons = new ArrayList<>();
	        for (int i = 0; i < 14; i++) {
	            persons.add(mockVO(i));
	        }
	        return persons;
	    }
	    
	    private PersonBO mockEntity(Integer number) {
	    	return PersonBO.builder()
	    	.firstName("First Name Test" + number)
	    	.address("Addres Test" + number)
	        .gender(((number % 2)==0) ? Gender.MALE : Gender.FEMALE)
	        .id(number.longValue()).build();
	    }

	    private PersonVO mockVO(Integer number) {
	    	return PersonVO.builder()
	    	    	.firstName("First Name Test" + number)
	    	    	.address("Addres Test" + number)
	    	        .gender(((number % 2)==0) ? Gender.MALE : Gender.FEMALE)
	    	        .id(number.longValue()).build();
	    }

}
