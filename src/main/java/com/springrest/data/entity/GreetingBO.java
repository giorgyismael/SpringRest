package com.springrest.data.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GreetingBO {
    private final long id;
    private final String content;

}
