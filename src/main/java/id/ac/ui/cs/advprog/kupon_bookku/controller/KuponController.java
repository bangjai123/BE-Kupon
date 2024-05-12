package id.ac.ui.cs.advprog.kupon_bookku.controller;

import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
import id.ac.ui.cs.advprog.kupon_bookku.service.KuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KuponController {

    @Autowired
    private KuponService kuponService;

    @GetMapping("/semua-kupon")
    public ResponseEntity<List<Kupon>> getAllKupon() {
        List<Kupon> semuaKupon = kuponService.getAllKupon();
        return ResponseEntity.ok(semuaKupon);
    }

    @GetMapping("/buat-kupon")
    public String showCreateKuponForm(Model model) {
        model.addAttribute("kupon", new Kupon());
        return "createKuponForm";
    }

    @PostMapping("/buat-kupon")
    public ResponseEntity<Kupon> createKupon(@ModelAttribute Kupon newKupon) {
        Kupon createdKupon = kuponService.createKupon(newKupon);
        return ResponseEntity.ok(createdKupon);
    }

    @PutMapping("/edit-kupon/{kuponId}")
    public ResponseEntity<Kupon> editKupon(@PathVariable String kuponId, @RequestBody Kupon updatedKupon) {
        kuponService.editKupon(kuponId, updatedKupon);
        return ResponseEntity.ok(updatedKupon);
    }

    @DeleteMapping("/delete-kupon/{kuponId}")
    public ResponseEntity<String> deleteKupon(@PathVariable String kuponId) {
        kuponService.deleteKupon(kuponId);
        return ResponseEntity.ok("Kupon berhasil dihapus");
    }

    @GetMapping("/gunakan-kupon/{kuponId}/{hargaAwal}")
    public ResponseEntity<String> gunakanKupon(@PathVariable String kuponId, @PathVariable String hargaAwal) {
        String hargaAkhir = kuponService.gunakanKupon(kuponId, hargaAwal);
        return ResponseEntity.ok(hargaAkhir);
    }
}