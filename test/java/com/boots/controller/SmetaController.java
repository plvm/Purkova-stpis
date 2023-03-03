package com.boots.controller;


import com.boots.entity.Kontrol;
import com.boots.entity.Smeta;
import com.boots.service.KontrolService;
import com.boots.service.SmetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Map;


//@Controller
@RestController
public class SmetaController {
    @Autowired
    private SmetaService smetaService;
    @Autowired
    private KontrolService ks;
 
    @RequestMapping(value = "/savessmeta", method = RequestMethod.POST)
    public String savesSmeta( Smeta smeta) throws IOException {

        Long kol=smeta.getKolvo();
        Double pr=smeta.getPric();
                  Double sum=kol*pr;
            smeta.setSumma(sum);
            smetaService.save(smeta);
        return "save smeta";    } 

    @RequestMapping("/deletesmeta")
    public String deleteSmetaForm(long id)throws IOException {
        smetaService.delete(id);
        return "delete smeta";
    }

 
    @RequestMapping("/smmeta")
    public List<Smeta>  homee() throws IOException {
        List<Smeta> listSmeta = smetaService.listAll();
        return smetaService.listAll();
    }
}
