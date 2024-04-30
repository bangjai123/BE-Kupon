package id.ac.ui.cs.advprog.kupon_bookku.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KuponController {
    @GetMapping("/")
    public String getHello() {
        return "Hello";
    }
}
