package id.ac.ui.cs.advprog.kupon_bookku.service;

import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;


import java.util.List;
import java.util.Optional;

public interface KuponService {
    Kupon createKupon(Kupon kupon);
    Kupon findById(String kuponId);

    @Async
    CompletableFuture<List<Kupon>> getAllKupon();
    void editKupon(String kuponId, Kupon kuponBaru);

    void deleteKupon(String kuponId);
    Kupon findKuponByKode(String kodeKupon);
    String gunakanKupon(String kuponId, String hargaAwal);
}
