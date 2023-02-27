package com.boots.controller;
import com.boots.entity.Podryadchik;
import com.boots.service.PodryadchikService;
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
public class PodryadchikController {
    @Autowired
    private PodryadchikService podryadchikser;
    @RequestMapping("/podryadchik")
    public ModelAndView home() {
        List<Podryadchik> listPodryadchik = podryadchikser.listAll();
        ModelAndView mav = new ModelAndView("podryadchik");
        mav.addObject("listPodryadchik", listPodryadchik);
        return mav;
    }
    @RequestMapping("/newpodryadchik")
    public String newPodryadchikForm(Map<String, Object> model) {
        Podryadchik podryadchik = new Podryadchik();
        model.put("podryadchik", podryadchik);
        return "new_podryadchik";
    }
    @RequestMapping(value = "/savepodryadchik", method = RequestMethod.POST)
    public String savePodryadchik(@ModelAttribute("podryadchik") Podryadchik podryadchik) {
        podryadchikser.save(podryadchik);
        return "redirect:/podryadchik";
    }
    @RequestMapping("/editpodryadchik")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_podryadchik");
        Podryadchik podryadchik = podryadchikser.get(id);
        mav.addObject("podryadchik", podryadchik);

        return mav;
    }

    @RequestMapping("/deletepodryadchik")
    public String deletePodryadchikForm(@RequestParam long id) {
        podryadchikser.delete(id);
        return "redirect:/podryadchik";
    }

}
