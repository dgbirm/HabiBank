package com.habibank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.habibank.model.Account;
//TODO Check to make sure id type matches up 
@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
}