package com.talvinder.singh.webservices.PersonsDetails;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonsController {
	// GET - /allpersons
	@GetMapping(path = "/persons")
	@CrossOrigin( origins = "*")
	@ResponseBody
	public List<Person> allPersons() {
		System.out.println("allPersons invoked...");
		PersonsDAOService pdao = new PersonsDAOService();
		List<Person>fetchList = pdao.findAll(); 
		return fetchList;
	}

    // GET - /find person for either first or last name provided.
	@GetMapping(path = "/persons/find")
	@CrossOrigin( origins = "*")
	@ResponseBody
	public List<Person> fewPersons(
			@RequestParam(required=false, defaultValue="") String fName,
			@RequestParam(required=false, defaultValue="") String lName) {
		
		System.out.println("fewPersons invoked: fName = "+ fName + " lName= " + lName );
		
		PersonsDAOService pdao = new PersonsDAOService();
	
		List<Person>fetchList = pdao.findOneOrMore(
				Optional.of(fName), 
				Optional.of(lName));
		 
		//return ResponseEntity.ok(fetchList);
		return fetchList;
				
	}

}
