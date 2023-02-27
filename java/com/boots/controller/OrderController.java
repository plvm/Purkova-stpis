package com.boots.controller;

import com.boots.entity.Customer;
import com.boots.entity.Kontrol;
import com.boots.entity.Order;
import com.boots.entity.Smeta;
import com.boots.service.CustomerService;
import com.boots.service.KontrolService;
import com.boots.service.OrderService;
import com.boots.service.SmetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SmetaService planService;
    @Autowired
    private KontrolService ks;
    @RequestMapping("/order")
    public ModelAndView homee() {
        List<Order> listOrder = orderService.listAll();
        Map<Integer, List<Order>> map = new HashMap<>();
map.put(1,listOrder);

        ModelAndView mavv = new ModelAndView("order");


        List<Kontrol> kss=ks.jornal(2L,2L);
        System.out.println(kss.size());
        List<Smeta> smm= planService.smetaList(2L,2L);
       // mavv.addObject("s", kss);
       // mavv.addObject("r", smm);
        return mavv;
    }
    @RequestMapping("/neworder")
    public String newOrderForm(Map<String, Object> model) {
        Order order = new Order();
        model.put("order", order);
        return "new_order";
    }
    @RequestMapping(value = "/saveorder", method = RequestMethod.POST)
    public String saveOrder(@ModelAttribute("order") Order order) {

        Long test=order.getNumbercustomer();
        List<Customer> customer= customerService.customersList((test));
        if(customer.size()>0){
        orderService.save(order);
        return "redirect:/order";}
        else return "no";
    }
    @RequestMapping("/editorder")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        Order order = orderService.get(id);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        List<Order> listOrder = orderService.listAll();
        paramMap.put("order", order);
        paramMap.put("listOrder", listOrder);
        ModelAndView mav = new ModelAndView("edit_order");
     //   Map<String, Object> resultMap = optionService.update_option_01(paramMap);
        mav.addAllObjects(paramMap);
       // mav.addObject("order", order);

        return mav;
    }
    @RequestMapping("/deleteorder")
    public String deleteOrderForm(@RequestParam long id) {
        orderService.delete(id);
        return "redirect:/order";
    }
}
