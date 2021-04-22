package com.springrest.data.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

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
@JsonPropertyOrder({ "id", "author", "launchDate", "price", "title" })
public class BookVO extends RepresentationModel implements Serializable{
 
	private static final long serialVersionUID = 1L;

	@Mapping("id_book")
	@JsonProperty("id")
	private Long key;
	
	private String author;
	private Date launchDate;
	private Double price;
	private String title;
	
}