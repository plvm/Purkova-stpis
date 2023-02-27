package com.boots.service;


import com.boots.entity.Podryadchik;
import com.boots.repository.CustomerRepository;
import com.boots.repository.PodryadchikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PodryadchikService {
    @Autowired
    PodryadchikRepository repo;

    public void save(Podryadchik podryadchik) {
        repo.save(podryadchik);
    }


    public List<Podryadchik> listAll() {
        return (List<Podryadchik>) repo.findAll();
    }

    public Podryadchik get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
