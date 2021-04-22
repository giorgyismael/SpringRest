package com.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.data.entity.BooksBO;

@Repository
public interface BookRepository extends JpaRepository<BooksBO, Long>{

}