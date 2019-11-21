package com.yarelosa.spaweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spaweb")
public class IndexController {

    @GetMapping({"/Index", "/home", "/", ""})
    public String index(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("name", "Principal of web application");
        return "/admin/index";
    }
}
