package id.ac.ui.cs.advprog.kupon_bookku.service;

import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;
import java.util.List;

public interface KuponService {

    @Async
    CompletableFuture<Kupon> createKupon(Kupon kupon);
    Kupon findById(String kuponId);

    @Async
    CompletableFuture<List<Kupon>> getAllKupon();

    @Async
    CompletableFuture<Void> editKupon(String kuponId, Kupon kuponBaru);

    @Async
    CompletableFuture<Void> deleteKupon(String kuponId);
    Kupon findKuponByKode(String kodeKupon);

    @Async
    CompletableFuture<String> gunakanKupon(String kuponId, String hargaAwal);

    @Async
    CompletableFuture<List<Kupon>> getAllKuponWithFilterAndSorting(String filter, String urutan);
}