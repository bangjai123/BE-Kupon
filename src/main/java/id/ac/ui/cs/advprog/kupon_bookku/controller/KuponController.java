package id.ac.ui.cs.advprog.kupon_bookku.controller;

import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
import id.ac.ui.cs.advprog.kupon_bookku.service.KuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
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


    @PostMapping("/buat-kupon")
    public ResponseEntity<Kupon> createKupon(@RequestBody HashMap<String, String> newKupon) {
        Kupon kupon = new Kupon();
        kupon.setNama(newKupon.get("nama"));
        kupon.setKode(newKupon.get("kode"));
        kupon.setPotonganHarga(newKupon.get("potonganHarga"));
        kupon.setPersentase(Double.parseDouble(newKupon.get("persentase")));
        kupon.setHargaMinimum(Integer.parseInt(newKupon.get("hargaMinimum")));
        kupon.setHargaMaksimum(Integer.parseInt(newKupon.get("hargaMaksimum")));
        kupon.setJenisKupon(newKupon.get("jenisKupon"));
        kupon.setStatusKupon(Boolean.parseBoolean(newKupon.get("statusKupon")));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        try {
            kupon.setTangalMulai(formatter.parse(newKupon.get("tangalMulai")));
            kupon.setTanggalSelesai(formatter.parse(newKupon.get("tanggalSelesai")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(kuponService.createKupon(kupon));
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/edit-kupon/{kuponId}")
    public ResponseEntity<Void> editKupon(@PathVariable String kuponId, @RequestBody HashMap<String, String> updatedKupon) {
        Kupon kupon = new Kupon();
        kupon.setNama(updatedKupon.get("nama"));
        kupon.setKode(updatedKupon.get("kode"));
        kupon.setPotonganHarga(updatedKupon.get("potonganHarga"));
        kupon.setPersentase(Double.parseDouble(updatedKupon.get("persentase")));
        kupon.setHargaMinimum(Integer.parseInt(updatedKupon.get("hargaMinimum")));
        kupon.setHargaMaksimum(Integer.parseInt(updatedKupon.get("hargaMaksimum")));
        kupon.setJenisKupon(updatedKupon.get("jenisKupon"));
        kupon.setStatusKupon(Boolean.parseBoolean(updatedKupon.get("statusKupon")));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        try {
            kupon.setTangalMulai(formatter.parse(updatedKupon.get("tangalMulai")));
            kupon.setTanggalSelesai(formatter.parse(updatedKupon.get("tanggalSelesai")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        kuponService.editKupon(kuponId, kupon);
        return ResponseEntity.ok().build();
    }
    
    @CrossOrigin(origins = "*")
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
