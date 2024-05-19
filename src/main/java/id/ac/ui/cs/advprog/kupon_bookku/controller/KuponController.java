package id.ac.ui.cs.advprog.kupon_bookku.controller;

import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
import id.ac.ui.cs.advprog.kupon_bookku.service.KuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class KuponController {

    @Autowired
    private KuponService kuponService;

    @GetMapping("/semua-kupon")
    public CompletableFuture<ResponseEntity<List<Kupon>>> getAllKupon() {
        return kuponService.getAllKupon().thenApply(ResponseEntity::ok);
    }

    @GetMapping("/buat-kupon")
    public String showCreateKuponForm(Model model) {
        model.addAttribute("kupon", new Kupon());
        return "createKuponForm";
    }

    @PostMapping("/buat-kupon")
    public CompletableFuture<ResponseEntity<Kupon>> createKupon(@ModelAttribute Kupon newKupon) {
        return kuponService.createKupon(newKupon).thenApply(ResponseEntity::ok);
    }

    @PutMapping("/edit-kupon/{kuponId}")
    public CompletableFuture<ResponseEntity<Void>> editKupon(@PathVariable String kuponId, @RequestBody Kupon updatedKupon) {
        return kuponService.editKupon(kuponId, updatedKupon).thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/delete-kupon/{kuponId}")
    public CompletableFuture<ResponseEntity<Void>> deleteKupon(@PathVariable String kuponId) {
        return kuponService.deleteKupon(kuponId).thenApply(ResponseEntity::ok);
    }

    @GetMapping("/gunakan-kupon/{kodeKupon}/{hargaAwal}")
    public CompletableFuture<ResponseEntity<String>> gunakanKupon(@PathVariable String kodeKupon, @PathVariable String hargaAwal) {
        return kuponService.gunakanKupon(kodeKupon, hargaAwal).thenApply(ResponseEntity::ok);
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
    public CompletableFuture<ResponseEntity<List<Kupon>>> getAllKuponWithFilterAndSorting(@PathVariable String filter, @PathVariable String urutan) {
        return kuponService.getAllKuponWithFilterAndSorting(filter, urutan).thenApply(ResponseEntity::ok);
    }
}