package xyz.pakwo.dashboard.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.pakwo.dashboard.model.ProductDto;
import xyz.pakwo.dashboard.service.ProductService;

/**
 * @author sarwo.wibowo
 **/
@Controller
@RequestMapping("modals")
@Slf4j
public class ModalController {

    @Autowired
    private ProductService productService;

    @GetMapping("modal1")
    public String modal1(Model model) {
        log.info("Retrieving matrix");
        model.addAttribute("matrix", productService.getMatrix());

        return "modal1";
    }

    @GetMapping("modal2")
    public String modal2(@RequestParam("id") Long id, Model model) {
        log.info("Getting product for id {}", id);
        ProductDto product = productService.getById(id);
        model.addAttribute("product", product);
        return "modal2";
    }
}
