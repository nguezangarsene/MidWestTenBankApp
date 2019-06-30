package com.midwesten.bank.controller.viewctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = {"/","/midwesten", "/midwesten/home"})
    public String displayHomePage() {
        return "public/home/index";
    }

}
