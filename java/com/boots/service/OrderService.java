package com.boots.service;

import com.boots.entity.Customer;
import com.boots.entity.Order;
import com.boots.repository.CustomerRepository;
import com.boots.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderRepository repo;

    public void save(Order order) {
        repo.save(order);
    }


    public List<Order> listAll() {
        return (List<Order>) repo.findAll();
    }

    public Order get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
