package xyz.pakwo.dashboard.controller;

import org.springframework.stereotype.Controller;
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
    public String main(ModelAndView mav) {
        return "index";
    }

    @GetMapping("/menu1")
    public String menu1(ModelAndView mav) {
        return "menu1";
    }
}
