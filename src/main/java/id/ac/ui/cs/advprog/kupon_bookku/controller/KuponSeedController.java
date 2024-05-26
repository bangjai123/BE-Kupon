package id.ac.ui.cs.advprog.kupon_bookku.controller;

import id.ac.ui.cs.advprog.kupon_bookku.service.KuponSeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class KuponSeedController {

    @Autowired
    private KuponSeedService kuponSeedService;

    @PostMapping("/seed-kupon")
    public void seedKupon() {
        kuponSeedService.seedKupon();
    }
}
