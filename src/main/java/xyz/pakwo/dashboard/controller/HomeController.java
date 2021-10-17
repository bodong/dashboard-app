package xyz.pakwo.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author sarwo.wibowo
 **/
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String main(Model model) {
        model.addAttribute("title", "Simple Dashboard Appplication");
        model.addAttribute("welcome", "Welcome to dashboard app. Click following modal to get each content");
        return "index";
    }

}
