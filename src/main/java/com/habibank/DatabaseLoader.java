package com.habibank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.habibank.repo.CustomerRepository;

//for having mock data to test.
@Component
public class DatabaseLoader implements CommandLineRunner {


    private final CustomerRepository repository;

	@Autowired
	public DatabaseLoader(CustomerRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		//this.repository.save(new Employee("Frodo", "Baggins", "ring bearer"));
	}
}