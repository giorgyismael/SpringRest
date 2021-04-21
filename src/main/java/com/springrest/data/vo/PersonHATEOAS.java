package com.springrest.data.vo;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
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
@JsonPropertyOrder({"id","firstName", "gender","address" })
public class PersonHATEOAS extends RepresentationModel implements Serializable {
	
	@Mapping("id_person")
	@JsonProperty("id")
	private Long key;
	
	@JsonProperty("First Name")
	private String firstName;
	
	@JsonProperty("Gender")
	private Gender gender;
	
	@JsonProperty("I'am living in the Cite")
	private String address;
}