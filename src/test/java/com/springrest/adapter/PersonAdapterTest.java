package com.springrest.adapter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.springrest.adapter.moks.MockPerson;
import com.springrest.data.entity.PersonBO;
import com.springrest.data.vo.PersonVO;
import com.springrest.enums.Gender;


public class PersonAdapterTest {

		MockPerson inputObject;

	 	@Before
	    public void setUp() {
	        inputObject = new MockPerson();
	    }

	    @Test
	    public void parseEntityToVOTest() {
	        PersonVO output = ObjectAdapter.parseObject(inputObject.mockEntity(), PersonVO.class);
	        Assert.assertEquals(Long.valueOf(0L), output.getId_person());
	        Assert.assertEquals("First Name Test0", output.getFirstName());
	        Assert.assertEquals("Addres Test0", output.getAddress());
	        Assert.assertEquals(Gender.MALE, output.getGender());
	    }

	    @Test
	    public void parseEntityListToVOListTest() {
	        List<PersonVO> outputList = ObjectAdapter.parseObjects(inputObject.mockEntitys(), PersonVO.class);
	        PersonVO outputZero = outputList.get(0);
	        
	        Assert.assertEquals(Long.valueOf(0L), outputZero.getId_person());
	        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
	        Assert.assertEquals("Addres Test0", outputZero.getAddress());
	        Assert.assertEquals(Gender.MALE, outputZero.getGender());
	        
	        PersonVO outputSeven = outputList.get(7);
	        
	        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId_person());
	        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
	        Assert.assertEquals("Addres Test7", outputSeven.getAddress());
	        Assert.assertEquals(Gender.FEMALE, outputSeven.getGender());
	        
	        PersonVO outputTwelve = outputList.get(12);
	        
	        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId_person());
	        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
	        Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
	        Assert.assertEquals(Gender.MALE, outputTwelve.getGender());
	    }

	    @Test
	    public void parseVOToEntityTest() {
	        PersonBO output = ObjectAdapter.parseObject(inputObject.mockVO(), PersonBO.class);
	        Assert.assertEquals(Long.valueOf(0L), output.getId_person());
	        Assert.assertEquals("First Name Test0", output.getFirstName());
	        Assert.assertEquals("Addres Test0", output.getAddress());
	        Assert.assertEquals(Gender.MALE, output.getGender());
	    }

	    @Test
	    public void parserVOListToEntityListTest() {
	        List<PersonBO> outputList = ObjectAdapter.parseObjects(inputObject.mockVOs(), PersonBO.class);
	        PersonBO outputZero = outputList.get(0);
	        
	        Assert.assertEquals(Long.valueOf(0L), outputZero.getId_person());
	        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
	        Assert.assertEquals("Addres Test0", outputZero.getAddress());
	        Assert.assertEquals(Gender.MALE, outputZero.getGender());
	        
	        PersonBO outputSeven = outputList.get(7);
	        
	        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId_person());
	        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
	        Assert.assertEquals("Addres Test7", outputSeven.getAddress());
	        Assert.assertEquals(Gender.FEMALE, outputSeven.getGender());
	        
	        PersonBO outputTwelve = outputList.get(12);
	        
	        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId_person());
	        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
	        Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
	        Assert.assertEquals(Gender.MALE, outputTwelve.getGender());
	    }

}
