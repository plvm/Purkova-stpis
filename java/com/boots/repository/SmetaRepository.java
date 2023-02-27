package com.boots.repository;

import com.boots.entity.Objekt;
import com.boots.entity.Smeta;
import com.boots.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface SmetaRepository extends CrudRepository<Smeta, Long> {
    User findByNumber(String number);

}

