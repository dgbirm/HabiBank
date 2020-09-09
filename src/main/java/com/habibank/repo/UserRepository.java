package com.habibank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.habibank.model.User;


@RepositoryRestResource
public interface UserRepository extends JpaRepository <User, Long> {

	Boolean existsByUserName(String userName);

	Boolean existsByEmail(String email);
}
