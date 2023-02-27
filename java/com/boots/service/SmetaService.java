package com.boots.service;



import com.boots.entity.Smeta;
import com.boots.repository.SmetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class SmetaService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    SmetaRepository repo;

    public void save(Smeta smeta) {
        repo.save(smeta);
    }


    public List<Smeta> listAll() {
        return (List<Smeta>) repo.findAll();
    }

    public Smeta get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Smeta>smetaList(Long idMin,Long idrab) {
        return em.createQuery("SELECT u FROM Smeta u WHERE u.numberobjekt = :paramId AND u.numberrabota=: test", Smeta.class)
                .setParameter("paramId", idMin)
                .setParameter("test", idrab).getResultList();
    }
    public void file(List<Smeta> listSm) throws IOException {
        String filename = "NewFile.txt";
        FileWriter fw = new FileWriter(filename);
        fw.write("Смета");
        fw.write("\n");
        for(int i=0;i<listSm.size();i++){
            fw.write("Номер сметы= "+listSm.get(i).getNumber()+" Номер объекта= "+listSm.get(i).getNumberobjekt()
                    +" Номер работы= "+listSm.get(i).getNumberrabota()+" Количество= "+listSm.get(i).getKolvo()+" Цена= "+listSm.get(i).getPric()+
                    " Cумма= "+listSm.get(i).getSumma());
            fw.write("\n");
            fw.flush();
        }
    }


}
