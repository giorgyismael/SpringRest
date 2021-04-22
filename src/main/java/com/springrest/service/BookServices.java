package com.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.DozerConverter;
import com.springrest.adapter.ObjectAdapter;
import com.springrest.data.entity.BooksBO;
import com.springrest.data.vo.BookVO;
import com.springrest.repository.BookRepository;

import lombok.var;

@Service
public class BookServices {
	
	@Autowired
	BookRepository repository;
		
	public BookVO create(BookVO book) {
		BooksBO entity = ObjectAdapter.parseObject(book, BooksBO.class);
		BookVO vo = ObjectAdapter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	
	public List<BookVO> findAll() {
		return ObjectAdapter.parseObjects(repository.findAll(), BookVO.class);
	}	
	
	public BookVO findById(Long id) {

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return ObjectAdapter.parseObject(entity, BookVO.class);
	}
		
	public BookVO update(BookVO book) {
		var entity = repository.findById(book.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		var vo = ObjectAdapter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}	
	
	public void delete(Long id) {
		BooksBO entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

}