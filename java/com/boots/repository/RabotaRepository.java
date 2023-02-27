package com.boots.repository;

import com.boots.entity.Customer;
import com.boots.entity.Rabota;
import com.boots.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface RabotaRepository extends CrudRepository<Rabota, Long> {
    User findByNumberrabota(Long numberrabota);

}
