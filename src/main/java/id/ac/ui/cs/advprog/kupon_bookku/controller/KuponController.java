package id.ac.ui.cs.advprog.kupon_bookku.controller;

import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
import id.ac.ui.cs.advprog.kupon_bookku.service.KuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class KuponController {

    @Autowired
    private KuponService kuponService;

    @GetMapping("/semua-kupon")
    public ResponseEntity<List<Kupon>> getAllKupon() {
        return ResponseEntity.ok(kuponService.getAllKupon());
    }

    @GetMapping("/buat-kupon")
    public String showCreateKuponForm(Model model) {
        model.addAttribute("kupon", new Kupon());
        return "createKuponForm";
    }

    @PostMapping("/buat-kupon")
    public ResponseEntity<Kupon> createKupon(@ModelAttribute Kupon newKupon) {
        return ResponseEntity.ok(kuponService.createKupon(newKupon));
    }

    @PutMapping("/edit-kupon/{kuponId}")
    public ResponseEntity<Void> editKupon(@PathVariable String kuponId, @RequestBody Kupon updatedKupon) {
        kuponService.editKupon(kuponId, updatedKupon);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-kupon/{kuponId}")
    public ResponseEntity<Void> deleteKupon(@PathVariable String kuponId) {
        kuponService.deleteKupon(kuponId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/gunakan-kupon/{kodeKupon}/{hargaAwal}")
    public ResponseEntity<String> gunakanKupon(@PathVariable String kodeKupon, @PathVariable String hargaAwal) {
        return ResponseEntity.ok(kuponService.gunakanKupon(kodeKupon, hargaAwal));
    }

    @GetMapping("/kupon/{id}")
    public ResponseEntity<Kupon> findKuponById(@PathVariable String id) {
        Kupon kupon = kuponService.findById(id);
        if (kupon != null) {
            return ResponseEntity.ok(kupon);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/kupon/kode/{kode}")
    public ResponseEntity<Kupon> findKuponByKode(@PathVariable String kode) {
        Kupon kupon = kuponService.findKuponByKode(kode);
        if (kupon != null) {
            return ResponseEntity.ok(kupon);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/semua-kupon/{filter}/{urutan}")
    public ResponseEntity<List<Kupon>> getAllKuponWithFilterAndSorting(@PathVariable String filter, @PathVariable String urutan) {
        return ResponseEntity.ok(kuponService.getAllKuponWithFilterAndSorting(filter, urutan));
    }
}