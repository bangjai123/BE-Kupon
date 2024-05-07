package id.ac.ui.cs.advprog.kupon_bookku.controller;

import id.ac.ui.cs.advprog.kupon_bookku.repository.KuponRepository;
import id.ac.ui.cs.advprog.kupon_bookku.service.KuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KuponController {

    @Autowired
    private KuponService kuponService;
    @GetMapping("/semua-kupon")
    public ResponseEntity<String> getAllKupon() {
        return ResponseEntity.ok("Semua kupon");
    }
    @PostMapping("/buat-kupon")
    @PostMapping("/edit-kupon")
    @DeleteMapping("/delete-kupon")
    @GetMapping("/gunakan-kupon")

}
