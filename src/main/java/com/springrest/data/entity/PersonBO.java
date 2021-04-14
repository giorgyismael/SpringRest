package com.springrest.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name="person")
public class PersonBO implements Serializable {

	private static final long serialVersionUID = -2493854977569193925L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_person;

	@Column(name="first_name", nullable = false, length = 64)
	private String firstName;
	
	@Column(name="gender", nullable = false, length = 16)
	private Gender gender;
	
	@Column(name="address", nullable = false, length = 128)
	private String address;
}