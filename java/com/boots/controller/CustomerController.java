package com.boots.controller;
import com.boots.entity.Customer;
import com.boots.entity.Podryadchik;
import com.boots.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpMethod.*;


//@Controller
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    //@RequestMapping(value = "/customer", method = GET, produces = MediaType.APPLICATION_JSON)
    //public ModelAndView home() {
    @GetMapping("/customer")
   // public List<Customer> home() {
    public ModelAndView home() {
        List<Customer> listCustomer = customerService.listAll();
        ModelAndView mav = new ModelAndView("customer");
        mav.addObject("listCustomer", listCustomer);
        // return mav;
        return mav;
    }
     @RequestMapping("/new")
    public String newCustomerForm(Map<String, Object> model) {
        Customer customer = new Customer();
        model.put("customer", customer);
        return "new_customer";
    }
   @RequestMapping(value = "/save", method = RequestMethod.POST)
    //@PostMapping(value = "/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customer";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_customer");
        Customer customer = customerService.get(id);
        mav.addObject("customer", customer);

        return mav;
    }
    @RequestMapping(value = "/editt", method = RequestMethod.GET)
    public Customer edittCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_customer");
        Customer customer = customerService.get(id);
        mav.addObject("customer", customer);

        return customer;
    }
    @DeleteMapping("/deletecustomer")
    public String deleteCustomerForm(@RequestParam long id) {
        customerService.delete(id);
        return "redirect:/customer";
    }

    @RequestMapping("/search")
    public ModelAndView searchCustomerForm(@RequestParam Long id) {

        List<Customer> customer= customerService.customersList(id);
        if(customer.size()>0) {
            ModelAndView mav = new ModelAndView("search");
            mav.addObject("customer", customerService.customersList(id));

        return mav;}
        else  { ModelAndView mavv = new ModelAndView("no"); return mavv;}

    }
    @RequestMapping("/orderby")
    public ModelAndView orderby() {
        List<Customer> listCustomerr = customerService.orderby();
        ModelAndView mav = new ModelAndView("customer");
        mav.addObject("listCustomer", listCustomerr);
        return mav;
    }
    @GetMapping("/customerr")
    public List<Customer> homee() {
        List<Customer> listCustomer = customerService.listAll();
        ModelAndView mav = new ModelAndView("customer");
        mav.addObject("listCustomer", listCustomer);
        // return mav;
        return listCustomer;
    }

    @RequestMapping("/searchh")
    public List<Customer> searchhCustomerForm(@RequestParam Long id) {

        List<Customer> customer= customerService.customersList(id);

            ModelAndView mav = new ModelAndView("search");
            mav.addObject("customer", customerService.customersList(id));

            return customer;


    }
       // else  { ModelAndView mavv = new ModelAndView("no"); customer;}
       @RequestMapping("/orderbyY")
       public  List<Customer> orderbyy() {
           List<Customer> listCustomerr = customerService.orderby();
           ModelAndView mav = new ModelAndView("customer");
           mav.addObject("listCustomer", listCustomerr);
           return listCustomerr ;
       }
  }

