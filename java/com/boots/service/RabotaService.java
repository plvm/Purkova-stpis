package com.boots.service;



import com.boots.entity.Rabota;
import com.boots.repository.RabotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class RabotaService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    RabotaRepository repo;

    public void save(Rabota rabota) {
        repo.save(rabota);
    }


    public List<Rabota> listAll() {
        return (List<Rabota>) repo.findAll();
    }

    public Rabota get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Rabota> rabotaList(Long idMin) {
        return em.createQuery("SELECT u FROM Rabota u WHERE u.numberrabota = :paramId", Rabota.class)
                .setParameter("paramId", idMin).getResultList();
    }

}
