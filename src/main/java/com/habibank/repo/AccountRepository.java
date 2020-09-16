package com.habibank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

import com.habibank.model.Account;
@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long> {
    





    //
}