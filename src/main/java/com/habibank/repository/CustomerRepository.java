package com.habibank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.habibank.model.Customer;


@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
}