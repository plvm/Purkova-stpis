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
    @RequestMapping("/smeta")
    public ModelAndView home() throws IOException {
        List<Smeta> listSmeta = smetaService.listAll();
        ModelAndView mav = new ModelAndView("smeta");
        smetaService.file(listSmeta);
        mav.addObject("listSmeta", listSmeta);
        return mav;
    }
    @RequestMapping("/newsmeta")
    public String newSmetaForm(Map<String, Object> model) {
        Smeta smeta = new Smeta();
        model.put("smeta", smeta);
        return "new_smeta";
    }
    @RequestMapping(value = "/savesmeta", method = RequestMethod.POST)
    public ModelAndView saveSmeta(@ModelAttribute("smeta") Smeta smeta) throws IOException {

        Long kol=smeta.getKolvo();
        Double pr=smeta.getPric();
        Long ob=smeta.getNumberobjekt();
        Long rab=smeta.getNumberrabota();
        List<Smeta> smetas=  smetaService.smetaList(ob,rab);
        if(smetas.size()<1){
            Double sum=kol*pr;
            smeta.setSumma(sum);
            smetaService.save(smeta);
            return home();}
        else{
            ModelAndView mav = new ModelAndView("searchsmeta");
            mav.addObject("smeta", smetas);
            return  mav;
        }}
    @RequestMapping(value = "/savessmeta", method = RequestMethod.POST)
    public String savesSmeta(@ModelAttribute("smeta") Smeta smeta) throws IOException {

        Long kol=smeta.getKolvo();
        Double pr=smeta.getPric();
        Long ob=smeta.getNumberobjekt();
        Long rab=smeta.getNumberrabota();
        List<Smeta> smetas=  smetaService.smetaList(ob,rab);

        return "redirect:/smeta";
    }
    @RequestMapping(value = "/savessmmeta", method = RequestMethod.POST)
    public ModelAndView savesSmmeta(@ModelAttribute("smeta") Smeta smeta) throws IOException {

        Long kol=smeta.getKolvo();
        Double pr=smeta.getPric();
        Long ob=smeta.getNumberobjekt();
        Long rab=smeta.getNumberrabota();
        List<Smeta> smetas=  smetaService.smetaList(ob,rab);
        if(smetas.size()<2){
            Double sum=kol*pr;
            smeta.setSumma(sum);
            smetaService.save(smeta);
            return home();}
        else{
            ModelAndView mav = new ModelAndView("searchsmeta");
            mav.addObject("smeta", smetas);
            return  mav;
        }}
    @RequestMapping("/editsmeta")
    public ModelAndView editSmetaForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_smeta");
        Smeta smeta = smetaService.get(id);

        mav.addObject("smeta", smeta);

        return mav;
    }
    @RequestMapping("/journalsmeta")
    public ModelAndView journalSmetaForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_smeta");
        Smeta smeta = smetaService.get(id);
        long ob=  smeta.getNumberobjekt();
        long ra=smeta.getNumberrabota();
        mav.addObject("smeta", smeta);
        ModelAndView mavv = new ModelAndView("order");


        List<Kontrol> kss=ks.jornal(ob,ra);
        System.out.println(kss.size());
        List<Smeta> smm=smetaService.smetaList(ob,ra);
        mavv.addObject("s", kss);
        mavv.addObject("r", smm);
        return mavv;
    }

    @RequestMapping("/deletesmeta")
    public String deleteSmetaForm(@RequestParam long id) {
        smetaService.delete(id);
        return "redirect:/smeta";
    }

    @RequestMapping("/searchsmetas")
    public ModelAndView searchSmetaForm(@RequestParam Long id) {


        ModelAndView mav = new ModelAndView("searchsmeta");
        return mav;}

    @RequestMapping("/smmeta")
    public List<Smeta>  homee() throws IOException {
        List<Smeta> listSmeta = smetaService.listAll();
        ModelAndView mav = new ModelAndView("smeta");
        smetaService.file(listSmeta);
        mav.addObject("listSmeta", listSmeta);
        return listSmeta;
    }
}
