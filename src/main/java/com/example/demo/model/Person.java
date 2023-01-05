package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	//A class that represents an immutable universally unique identifier (UUID).
	//A UUID represents a 128-bit value
	
	private final UUID id;
	private final String name;
	
	public Person(@JsonProperty("id")UUID id,
			      @JsonProperty("name")String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public UUID getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
}
