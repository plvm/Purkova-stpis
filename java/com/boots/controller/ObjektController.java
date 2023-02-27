package com.boots.controller;


import com.boots.entity.Objekt;
import com.boots.service.ObjektService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Controller
public class ObjektController {
    @Autowired
    private ObjektService objektService;
    @RequestMapping("/objekt")
    public ModelAndView home() {
        List<Objekt> listObjekt = objektService.listAll();
        ModelAndView mav = new ModelAndView("objekt");
        mav.addObject("listObjekt", listObjekt);
        return mav;
    }
    @RequestMapping("/newobjekt")
    public String newObjektForm(Map<String, Object> model) {
        Objekt objekt = new Objekt();
        model.put("objekt", objekt);
        return "new_objekt";
    }
    @RequestMapping(value = "/saveobjekt", method = RequestMethod.POST)
    public String saveObjekt(@ModelAttribute("objekt") Objekt objekt) {
       objektService.save(objekt);
        return "redirect:/objekt";
    }
    @RequestMapping("/editobjekt")
    public ModelAndView editObjektForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_objekt");
        Objekt objekt = objektService.get(id);
        mav.addObject("objekt", objekt);

        return mav;
    }

    @RequestMapping("/deleteobjekt")
    public String deleteObjektForm(@RequestParam long id) {
       objektService.delete(id);
        return "redirect:/objekt";
    }

    @RequestMapping("/searchobjekt")
    public ModelAndView searchObjektForm(@RequestParam Long id) {

        List<Objekt> objekt= objektService.objektsList(id);
        if(objekt.size()>0) {
            ModelAndView mav = new ModelAndView("searchobjekt");
            mav.addObject("objekt", objektService.objektsList(id));

        return mav;}
        else  { ModelAndView mavv = new ModelAndView("no"); return mavv;}

    }
}
