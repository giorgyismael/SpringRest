package com.springrest.data.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.springrest.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonPropertyOrder({"firstName", "gender","address" })
public class PersonVO implements Serializable {
	
	private Long id_person;
	
	@JsonProperty("First Name")
	private String firstName;
	
	@JsonProperty("Gender")
	private Gender gender;
	
	@JsonProperty("I'am living in the Cite")
	private String address;
}