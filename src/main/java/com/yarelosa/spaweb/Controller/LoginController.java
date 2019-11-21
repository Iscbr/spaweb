package com.yarelosa.spaweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spaweb")
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        return "/cliente/form";
    }
}
