package com.boots.controller;

import com.boots.entity.Smeta;
import com.boots.service.KontrolService;
import com.boots.service.SmetaService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SmetaControllerTest {
    @Autowired
    private SmetaService smetaService;
    @Autowired
    private KontrolService ks;
    @Autowired
    private SmetaController kont;


    /*
   public String savesSmeta( Smeta smeta) throws IOException {

        Long kol=smeta.getKolvo();
        Double pr=smeta.getPric();
                //List<Smeta> smetas=  smetaService.smetaList(ob,rab);
                  Double sum=kol*pr;
            smeta.setSumma(sum);
            smetaService.save(smeta);

        return "save smeta";A
    }
     */

    @Test
    void homee() throws IOException {
        List<Smeta> listSmeta =kont.homee();
        assertEquals(3,listSmeta.size());
    }
    @Test
    void savesSmeta() throws IOException {

Smeta smeta = new Smeta();

smeta.setNumber(1L);
smeta.setNumberobjekt(1111L);
smeta.setNumberrabota(1111L);
smeta.setKolvo(100L);
smeta.setPric(10.0);

     Long kol=smeta.getKolvo();
      Double pr=smeta.getPric();
      Double sum=kol*pr;
        String st= kont.savesSmeta(smeta);
        assertEquals("save smeta",st);
    }
 /*   @RequestMapping("/deletesmeta")
    public String deleteSmetaForm(@RequestParam long id) {
        smetaService.delete(id);
        return "delete smeta";
    }

*/

    @Test
    void deleteSmetaFor() throws IOException {
        String st= kont.deleteSmetaForm(2234L);
        assertEquals("delete smeta",st);

    }

}