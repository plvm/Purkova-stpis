package com.boots.service;


import com.boots.entity.Objekt;
import com.boots.repository.CustomerRepository;
import com.boots.repository.ObjektRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class ObjektService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    ObjektRepository repo;

    public void save(Objekt objekt) {
        repo.save(objekt);
    }


    public List<Objekt> listAll() {
        return (List<Objekt>) repo.findAll();
    }

    public Objekt get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Objekt> objektsList(Long idMin) {
        return em.createQuery("SELECT u FROM Objekt u WHERE u.numberobjekt = :paramId", Objekt.class)
                .setParameter("paramId", idMin).getResultList();
    }

}
