package com.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.data.entity.PersonBO;

@Repository
public interface PersonRepository extends JpaRepository<PersonBO, Long> {

}
