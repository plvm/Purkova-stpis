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
    @RequestMapping("/kontrol")
    public ModelAndView home() throws IOException {
        List<Kontrol> listKontrol = kontrolService.listAll();
        ModelAndView mav = new ModelAndView("kontrol");
        mav.addObject("listKontrol", listKontrol);

        return mav;
    }
    @RequestMapping("/newkontrol")
    public String newKontrolForm(Map<String, Object> model) {
       Kontrol kontrol = new Kontrol();
        model.put("kontrol", kontrol);
        return "new_kontrol";
    }
    @RequestMapping(value = "/savekontrol", method = RequestMethod.POST)
    public String saveKontrol(@ModelAttribute("kontrol") Kontrol kontrol) {
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
              //long kl = kontr.get(kontr.size() - 1).getKolvo();
             // kontrol.setKolvo(kl - kolvv);
             // kontrolService.save(kontrol);
              Kontrol kon=kontr.get(i);

              if(i==0){

             long v=kon.getKolvo();
                  System.out.println(v);
                  long y= kol-kolvv;
                  System.out.println(y);
             // kon.setKolvoost(y);
                  kon.setKolvoost(y);



          }

          else {

                  Kontrol konn=kontr.get(i-1);
                  long k=kon.getKolvo();
                  long m=konn.getKolvoost();
                  System.out.println(m-k);
                  kon.setKolvoost(m-k);
                 // kontrolService.save(kon);

              }
              kontrolService.save(kon);
          }

          return "redirect:/kontrol";

     //   List<Objekt> objekt= obService.objektsList(id);
     //   List<Smeta> smeta= oService.smetaList(id);
     //   Smeta sm=;


    }
    @RequestMapping("/editkontrol")
    public ModelAndView editSmetaForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_kontrol");
        Kontrol kontrol = kontrolService.get(id);
        mav.addObject("kontrol", kontrol);

        return mav;
    }

    @RequestMapping("/deletekontrol")
    public String deleteKontrolForm(@RequestParam long id) {
        kontrolService.delete(id);
        return "redirect:/kontrol";
    }

    @RequestMapping("/searchkontrol")
    public ModelAndView searchKontrolForm(@RequestParam Long id) {

        List<Kontrol> smeta= kontrolService.kontrolsList(id);
        if(smeta.size()>0) {
            ModelAndView mav = new ModelAndView("searchkontrol");
            mav.addObject("kontrol", kontrolService.kontrolsList(id));

        return mav;}
        else  { ModelAndView mavv = new ModelAndView("no"); return mavv;}

    }
    @RequestMapping("/searchwork")
    public ModelAndView searchCustomerForm(@RequestParam Long id) {

        List<Rabota> rabota= rabotaService.rabotaList(id);
        System.out.println(id);
        if(rabota.size()>0) {
            ModelAndView mav = new ModelAndView("searchwork");
            mav.addObject("rabota",rabotaService.rabotaList(id));

            return mav;}
        else  { ModelAndView mavv = new ModelAndView("no"); return mavv;}

    }
    @RequestMapping("/searchobjektt")
    public ModelAndView searchObjektForm(@RequestParam Long id) {
System.out.println(id);
        List<Objekt> objekt= objektService.objektsList(id);
        if(objekt.size()>0) {
            ModelAndView mav = new ModelAndView("searchobjektt");
            mav.addObject("objekt", objektService.objektsList(id));

            return mav;}
        else  { ModelAndView mavv = new ModelAndView("no"); return mavv;}

    }
    @RequestMapping("/kontroll")
    public List<Kontrol> homee() throws IOException {
        List<Kontrol> listKontrol = kontrolService.listAll();
        ModelAndView mav = new ModelAndView("kontrol");
        mav.addObject("listKontrol", listKontrol);

        return listKontrol;
    }
    @RequestMapping("/searchwwork")
    public List<Rabota> searchCustomerrForm(@RequestParam Long id) {

        List<Rabota> rabota= rabotaService.rabotaList(id);
        System.out.println(id);

        ModelAndView mav = new ModelAndView("searchwork");
        mav.addObject("rabota",rabotaService.rabotaList(id));

        return rabota;

    }
    @RequestMapping("/searchoobjektt")
    public List<Objekt> searchOObjektForm(@RequestParam Long id) {
        System.out.println(id);
        List<Objekt> objekt= objektService.objektsList(id);

            ModelAndView mav = new ModelAndView("searchobjektt");
            mav.addObject("objekt", objektService.objektsList(id));

            return objekt;}



}
