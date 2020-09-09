package com.habibank.repo;

import java.util.Optional;

import com.habibank.model.Role;
import com.habibank.model.Role.ERole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}