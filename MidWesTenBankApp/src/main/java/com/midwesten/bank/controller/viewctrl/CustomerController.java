package com.midwesten.bank.controller.viewctrl;


import com.midwesten.bank.model.Customer;
import com.midwesten.bank.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/midwesten/secured/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = "/browse")
    public ModelAndView displayListOfCustomers() {
        ModelAndView modelAndView = new ModelAndView();
        List<Customer> customers = customerService.getAllCustomers();
        modelAndView.addObject("customers", customers);
        modelAndView.setViewName("secured/customer/browse");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public String newCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "secured/customer/new";
    }

    @PostMapping(value = "/new")
    public String addNewCustomer(@Valid @ModelAttribute("customer") Customer customer,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/customer/new";
        }
        customer = customerService.addNewCustomer(customer);
        return "redirect:/midwesten/secured/customer/browse";
    }


}
