package com.habibank.services;
import org.springframework.data.domain.page;
import org.springframework.data.domain.pageable;

public interface IService<T> {
    
    Page<T> findAll(Pageable pageable);

    T FindById(Integer id);

    T saveOrUpdate(T t);

    String deleteById(Integer id);



}