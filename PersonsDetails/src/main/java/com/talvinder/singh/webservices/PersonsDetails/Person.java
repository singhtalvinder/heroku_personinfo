package com.talvinder.singh.webservices.PersonsDetails;

// The person class.
public class Person {

	private String firstName;
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	private String lastName;

	public Person(String fName, String lName) {
		firstName = fName;
		lastName = lName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


}
