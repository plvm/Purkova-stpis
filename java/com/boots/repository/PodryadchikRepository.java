package com.boots.repository;


import com.boots.entity.Podryadchik;
import com.boots.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface PodryadchikRepository extends CrudRepository<Podryadchik, Long> {
    User findByNumberpodryadchik(String numberpodryadchik);

}
