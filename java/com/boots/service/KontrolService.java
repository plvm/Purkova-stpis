package com.boots.service;




import com.boots.entity.Kontrol;
import com.boots.repository.KontrolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class KontrolService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    KontrolRepository repo;

    public void save(Kontrol kontrol) {
        repo.save(kontrol);
    }


    public List<Kontrol> listAll() {
        return (List<Kontrol>) repo.findAll();
    }

    public Kontrol get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Kontrol>kontrolsList(Long idMin) {
        return em.createQuery("SELECT u FROM Kontrol u WHERE u.numberkontrol = :paramId", Kontrol.class)
                .setParameter("paramId", idMin).getResultList();
    }
    public List<Kontrol>jornal(Long o, Long r) {
        return em.createQuery("SELECT u FROM Kontrol u WHERE u.numberobjekt = :paramId AND u.numberrabota=: test", Kontrol.class)
                .setParameter("paramId", o)
                .setParameter("test", r).getResultList();
    }

}
