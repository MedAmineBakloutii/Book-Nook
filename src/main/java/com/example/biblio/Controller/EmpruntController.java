package com.example.biblio.Controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class EmpruntController {
    @GetMapping("/home")
    public String home(Model model) {
        return "Home";


    }
}
