package com.boots.repository;

import java.util.List;

import com.boots.entity.Customer;
import com.boots.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    User findByNumbercustomer(Long numbercustomer);

}
