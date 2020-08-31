package com.habibank.services;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

public interface IService<T> {
    
    Page<T> findAll(Pageable pageable);

    T FindById(Integer id);

    T saveOrUpdate(T t);

    String deleteById(Integer id);



}