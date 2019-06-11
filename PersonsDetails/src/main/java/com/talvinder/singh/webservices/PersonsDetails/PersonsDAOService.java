package com.talvinder.singh.webservices.PersonsDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class PersonsDAOService {
	private static List<Person> persons = new ArrayList<>();
	
	static {
		persons.add(new Person("Mark", "Si"));
		persons.add(new Person("ALi", "woa"));
		persons.add(new Person("roland", "ma"));
		persons.add(new Person("Mary", "wro"));
	}
	
	// Find all persons.
	public List<Person> findAll() {
		System.out.println("Executing: findAll........");
		return persons;
	}
	
	// Find specific persons.
	public List<Person> findOneOrMore(
			Optional<String> fName, 
			Optional<String> lName) {
		String _fName = fName.isPresent() ? fName.get() : null;
		String _lName = lName.isPresent() ? lName.get() : null;
		
		System.out.println("Executing: findOneorMore........");
		
		List<Person> result= new ArrayList<>();
		// Nothing specified in search criteria.
		if(_fName == null && _lName == null) {
			result.add(new Person("", ""));
			return result; 
		}
		
		for(Person person: persons) {
			String mfName = person.getFirstName();
			String mlName = person.getLastName();
		
			if(_fName != null && _lName == null) {
				if(0 == mfName.compareToIgnoreCase(_fName)) {
					result.add(new Person(mfName, mlName));
				}
			} else if(_fName == null && _lName != null) {
				if(0 == mlName.compareToIgnoreCase(_lName)) {
					result.add(new Person(mfName, mlName));
				}
			} else if(_fName != null && _lName != null) {
				if(0 == mfName.compareToIgnoreCase(_fName)) {
					result.add(new Person(mfName, mlName));
				}
				if(0 == mlName.compareToIgnoreCase(_lName)) {
					result.add(person);
				}
			}
		}
		
		return result;
	}
}
