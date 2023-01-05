package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;

//Interface easy to use any where
//Abstract Class
public interface PersonDao {
	
	//Abstract Method
	int insertPerson(UUID id,Person person);
	
	//This interface is implemented in FakePersonData to insert Person  detail
	
	//Select All People use to show values of list
	
   	
	default int insertPerson(Person person)
	{
		UUID id = UUID.randomUUID();
		
		return insertPerson(id,person);
	}
	
	int deletePersonById(UUID id);
	
	int updatePersonById(UUID id, Person person);
	
	Optional<Person> findPersonById(UUID id);
	
	List<Person> selectAllPeople();
	
	
}
