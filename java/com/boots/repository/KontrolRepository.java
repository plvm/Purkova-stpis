package com.boots.repository;

import com.boots.entity.Kontrol;
import com.boots.entity.Objekt;
import com.boots.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface KontrolRepository extends CrudRepository<Kontrol, Long> {
    User findByNumberkontrol(String numberkontrol);

}

