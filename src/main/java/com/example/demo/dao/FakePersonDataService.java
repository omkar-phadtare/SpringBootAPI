package com.example.demo.dao;
import java.util.*;
import java.io.*;
import java.sql.*;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("fakeDao")
public class FakePersonDataService implements PersonDao{

	
	private static List<Person> DB = new ArrayList<>();
	@Override
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		DB.add(new Person(id,person.getName()));
		return 1;
	}
	@Override
	public List<Person> selectAllPeople() {
		// TODO Auto-generated method stub
		return DB;
	}
	@Override
	public int deletePersonById(UUID id) {
		Optional<Person> personMayBe = findPersonById(id);
		if(personMayBe.isEmpty()) {
			return 0;
		}
		DB.remove(personMayBe.get());
		return 0;
	}
	@Override
	public int updatePersonById(UUID id, Person person) {
		return findPersonById(id).map(p -> {
			int indexOfPersonToDelete = DB.indexOf(person);
			if(indexOfPersonToDelete>=0)
			{
				DB.set(indexOfPersonToDelete, person);
				return 1;
			}
		return 0;
		}).orElse(0);
	}
	@Override
	public Optional<Person> findPersonById(UUID id) {
		// TODO Auto-generated method stub
		return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
		}
	
	
}
