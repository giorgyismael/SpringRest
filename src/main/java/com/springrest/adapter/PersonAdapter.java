package com.springrest.adapter;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import lombok.experimental.UtilityClass;

@Component
public class PersonAdapter {
	
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

	public static <O,D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}
	
	public static <O,D> List<D> parseObjects(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<D>();
		for (Object object : origin) {
			destinationObjects.add(mapper.map(object, destination));
		}
		return destinationObjects;
	}
}
