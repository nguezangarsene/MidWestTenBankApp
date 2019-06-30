package com.midwesten.bank.controller.viewctrl;

import com.midwesten.bank.model.Account;
import com.midwesten.bank.model.AccountType;
import com.midwesten.bank.model.Customer;
import com.midwesten.bank.service.IAccountService;
import com.midwesten.bank.service.IAccountTypeService;
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
@RequestMapping(value = "/midwesten/secured/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IAccountTypeService accountTypeService;

    @GetMapping(value = "/browse")
    public ModelAndView displayListOfAccounts() {
        ModelAndView modelAndView = new ModelAndView();
        List<Account> accounts = accountService.getAllAccounts();
        modelAndView.addObject("accounts", accounts);
        Double netLiquidity = accountService.computeNetLiquidity();
        modelAndView.addObject("netLiquidity", netLiquidity);
        modelAndView.setViewName("secured/account/browse");
        return modelAndView;
    }

    @GetMapping(value = "/new")
//    public ModelAndView newProductForm(Model model) {
    public String newAccountForm(Model model) {
//        ModelAndView modelAndView = new ModelAndView();
        List<Customer> customers = customerService.getAllCustomers();
        List<AccountType> accountTypes = accountTypeService.getAllAccountTypes();
//        modelAndView.addObject("suppliers", suppliers);
//        modelAndView.setViewName("secured/product/new");
        model.addAttribute("account", new Account());
        model.addAttribute("customers", customers);
        model.addAttribute("accountTypes", accountTypes);
//        return modelAndView;
        return "secured/account/new";
    }

    @PostMapping(value = "/new")
    public String addNewAccount(@Valid @ModelAttribute("account") Account account,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            List<Customer> customers = customerService.getAllCustomers();
            model.addAttribute("customers", customers);
            List<AccountType> accountTypes = accountTypeService.getAllAccountTypes();
            model.addAttribute("accountTypes", accountTypes);
            return "secured/account/new";
        }
        account = accountService.addNewAccount(account);
        return "redirect:/midwesten/secured/account/browse";
    }



}
