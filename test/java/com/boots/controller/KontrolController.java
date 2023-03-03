package com.boots.controller;




import com.boots.entity.Kontrol;
import com.boots.entity.Objekt;
import com.boots.entity.Rabota;
import com.boots.entity.Smeta;
import com.boots.service.KontrolService;
import com.boots.service.ObjektService;
import com.boots.service.RabotaService;
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
public class KontrolController {
    @Autowired
    private KontrolService kontrolService;
    @Autowired
    private SmetaService oService;
    @Autowired
    private ObjektService objektService;
    @Autowired
    private RabotaService rabotaService;
    
    @RequestMapping(value = "/savekontrol", method = RequestMethod.POST)
    public String saveKontrol ( Kontrol kontrol) {
        Long kolvv=kontrol.getKolvo();
        Double  price=kontrol.getPrice();
        Double summa=kolvv*price;
        kontrol.setSumma(summa);
        kontrol.setKolvoost(0l);
        kontrolService.save(kontrol);
      Long id=kontrol.getNumberobjekt();
      Long idr=kontrol.getNumberrabota();
      List<Smeta> sm=oService.smetaList(id,idr);
      Smeta smm=sm.get(0);
      long kol=smm.getKolvo();
        System.out.println(kol);
      List<Kontrol> kontr=kontrolService.jornal(id,idr);
          for (int i = 0; i < kontr.size(); i++) {
            long kl = kontr.get(kontr.size() - 1).getKolvo();
              kontrol.setKolvo(kl - kolvv);
             kontrolService.save(kontrol);
              Kontrol kon=kontr.get(i);
              if(i==0){
             long v=kon.getKolvo();
                  long y= kol-kolvv;
                  kon.setKolvoost(y);
              }
              else {
              Kontrol konn=kontr.get(i-1);
          long k=kon.getKolvo();
                  long m=konn.getKolvoost();
                  System.out.println(m-k);
                  kon.setKolvoost(m-k);                 }
              kontrolService.save(kon);          }
          return "save kontrol";

     //   List<Objekt> objekt= obService.objektsList(id);
     //   List<Smeta> smeta= oService.smetaList(id);
     //   Smeta sm=;


    }

    @RequestMapping("/deletekontrol")
     public String deleteKontrolForm(@RequestParam long id)
    {               kontrolService.delete(id);         return "delete kontrol";    }


    @RequestMapping("/kontroll")
    public List<Kontrol> homee()   {
        List<Kontrol> listKontrol = kontrolService.listAll();
        return listKontrol;    }



    @RequestMapping("/searchwwork")
    public List<Rabota> searchCustomerrForm(Long id) {

        List<Rabota> rabota= rabotaService.rabotaList(id);
        return rabota;

    }
    @RequestMapping("/searchoobjektt")
    public List<Objekt> searchOObjektForm(Long id) {
        List<Objekt> objekt= objektService.objektsList(id);
            return objekt;}



}
