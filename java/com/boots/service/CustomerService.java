package com.boots.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.boots.entity.Customer;
import com.boots.entity.User;
import com.boots.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class CustomerService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    CustomerRepository repo;

    public void save(Customer customer) {
        repo.save(customer);
    }


    public List<Customer> listAll() {
        return (List<Customer>) repo.findAll();
    }

    public Customer get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Customer> customersList(Long idMin) {
        return em.createQuery("SELECT u FROM Customer u WHERE u.numbercustomer = :paramId", Customer.class)
                .setParameter("paramId", idMin).getResultList();
    }
    public List<Customer> orderby() {
        return em.createQuery("SELECT u FROM Customer u order by u.name", Customer.class)
                .getResultList();
    }

}
