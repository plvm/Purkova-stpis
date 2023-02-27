package com.boots.controller;



import com.boots.entity.Rabota;
import com.boots.service.RabotaService;
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
public class RabotaController {
    @Autowired
    private RabotaService rabotaService;
    @RequestMapping("/rabota")
    public ModelAndView home() {
        List<Rabota> listRabota = rabotaService.listAll();
        ModelAndView mav = new ModelAndView("rabota");
        mav.addObject("listRabota", listRabota);
        return mav;
    }
    @RequestMapping("/newrabota")
    public String newRabotaForm(Map<String, Object> model) {
        Rabota rabota = new Rabota();
        model.put("rabota", rabota);
        return "new_rabota";
    }
    @RequestMapping(value = "/saverabota", method = RequestMethod.POST)
    public String saveRabota(@ModelAttribute("rabota") Rabota rabota) {
        rabotaService.save(rabota);
        return "redirect:/rabota";
    }
    @RequestMapping("/editrabota")
    public ModelAndView editRabotaForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_rabota");
        Rabota rabota = rabotaService.get(id);
        mav.addObject("rabota", rabota);

        return mav;
    }

    @RequestMapping("/deleterabota")
    public String deleteRabotaForm(@RequestParam long id) {
        rabotaService.delete(id);
        return "redirect:/rabota";
    }

    @RequestMapping("/searchrabota")
    public ModelAndView searchCustomerForm(@RequestParam Long id) {

        List<Rabota> rabota= rabotaService.rabotaList(id);
        if(rabota.size()<0) {
            ModelAndView mav = new ModelAndView("searchrabota");
            mav.addObject("rabota",rabotaService.rabotaList(id));

        return mav;}
        else  { ModelAndView mavv = new ModelAndView("no"); return mavv;}

    }
}
