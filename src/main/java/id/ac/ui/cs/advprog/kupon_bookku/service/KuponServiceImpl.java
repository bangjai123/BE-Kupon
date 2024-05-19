package id.ac.ui.cs.advprog.kupon_bookku.service;


import id.ac.ui.cs.advprog.kupon_bookku.enums.JenisKupon;
import id.ac.ui.cs.advprog.kupon_bookku.model.*;
import id.ac.ui.cs.advprog.kupon_bookku.repository.KuponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@EnableAsync
public class KuponServiceImpl implements  KuponService {
    @Autowired
    private KuponRepository kuponRepository;

    private Map<String, Strategy> strategyMap = new HashMap<>();

    public KuponServiceImpl() {
        strategyMap.put(JenisKupon.DISKONHARGA.getValue(), new DiskonHarga());
        strategyMap.put(JenisKupon.DISKONHARGADENGANMAKSIMUM.getValue(), new DiskonHargaDenganMaksimum());
        strategyMap.put(JenisKupon.DISKONHARGADENGANMINIMUM.getValue(), new DiskonHargaDenganMinimum());
        strategyMap.put(JenisKupon.DISKONHARGADENGANMINMUMDANMAKSIMUM.getValue(), new DiskonHargaDenganMinimumDanMaksimum());
        strategyMap.put(JenisKupon.DISKONPERSENTASE.getValue(), new DiskonPersentase());
        strategyMap.put(JenisKupon.DISKONPERSENTASEDENGANMAKSIMUM.getValue(), new DiskonPersentaseDenganMaksimum());
        strategyMap.put(JenisKupon.DISKONPERSENTASEDENGANMINIMUM.getValue(), new DiskonPersentaseDenganMinimum());
        strategyMap.put(JenisKupon.DISKONPERSENTASEDENGANMINIMUMDANMAKSIMUM.getValue(), new DiskonPersentaseDenganMinimumDanMaksimum());
    }

    @Override
    @Async
    public CompletableFuture<Kupon> createKupon(Kupon kupon) {
        Kupon createdKupon = kuponRepository.save(kupon);
        return CompletableFuture.completedFuture(createdKupon);
    }

    @Override
    public Kupon findById(String kuponId) {
        Optional<Kupon> kuponDicari = kuponRepository.findById(kuponId);
        if (kuponDicari.isPresent()) {
            return kuponDicari.get();
        }
        return null;
    }

    @Override
    @Async
    public CompletableFuture<List<Kupon>> getAllKupon() {
        List<Kupon> semuaKupon = kuponRepository.findAll();
        return CompletableFuture.completedFuture(semuaKupon);
    }

    @Override
    @Async
    public CompletableFuture<Void> editKupon(String kuponId, Kupon kuponBaru) {
        Optional<Kupon> diubah = kuponRepository.findById(kuponId);
        if(diubah.isPresent()){
            Kupon kuponDiubah = diubah.get();
            kuponDiubah.setKode(kuponBaru.getKode());
            kuponDiubah.setJenisKupon(kuponBaru.getJenisKupon());
            kuponDiubah.setPotonganHarga(kuponBaru.getPotonganHarga());
            kuponDiubah.setTanggalSelesai(kuponBaru.getTanggalSelesai());
            kuponRepository.save(kuponDiubah);
        }
        return CompletableFuture.completedFuture(null);
    }

    @Override
    @Async
    public CompletableFuture<Void> deleteKupon(String kuponId) {
        if(kuponRepository.findById(kuponId).isPresent()){
            kuponRepository.delete(kuponRepository.findById(kuponId).get());
        }
        return CompletableFuture.completedFuture(null);
    }
    @Override
    public Kupon findKuponByKode(String kodeKupon) {
        if(kuponRepository.findByKode(kodeKupon).isPresent()) {
            return kuponRepository.findByKode(kodeKupon).get();
        }
        else return null;
    }

    @Override
    @Async
    public CompletableFuture<String> gunakanKupon(String kodeKupon, String hargaAwal) {
        Optional<Kupon> kuponDicari = kuponRepository.findByKode(kodeKupon);
        if(kuponDicari.isPresent() && kuponDicari.get().isValid()){
            Kupon kuponDigunakan = kuponDicari.get();
            Strategy strategy = strategyMap.get(kuponDigunakan.getJenisKupon());
            strategy.setPersentase(kuponDigunakan.getPersentase());
            strategy.setMinimumHarga(kuponDigunakan.getHargaMinimum());
            strategy.setMaksimumPotongan(kuponDigunakan.getHargaMaksimum());
            strategy.setPotonganHarga(Long.parseLong(kuponDigunakan.getPotonganHarga()));
            long hargaAkhir = strategy.calculateDiscount(Long.parseLong(hargaAwal));
            return CompletableFuture.completedFuture("" + hargaAkhir);
        }
        return CompletableFuture.completedFuture("Kupon tidak valid "+kuponDicari.get().isValid());
    }

    @Override
    @Async
    public CompletableFuture<List<Kupon>> getAllKuponWithFilterAndSorting(String filter, String urutan) {
        List<Kupon> semuaKupon = null;
        if(filter.equals("harga")){
            if(urutan.equals("asc")){
                semuaKupon = kuponRepository.findByJenisKuponContainingOrderByPotonganHargaAsc("DH");
            }
            else if(urutan.equals("desc")){
                semuaKupon = kuponRepository.findByJenisKuponContainingOrderByPotonganHargaDesc("DH");
            }
            else if (urutan.equals("none")){
                semuaKupon = kuponRepository.findByJenisKuponContaining("DH");
            }

        }
        else if(filter.equals("persentase")){
            if(urutan.equals("asc")){
                semuaKupon = kuponRepository.findByJenisKuponContainingOrderByPersentaseAsc("DP");
            }
            else if(urutan.equals("desc")){
                semuaKupon = kuponRepository.findByJenisKuponContainingOrderByPersentaseDesc("DP");
            }
            else if (urutan.equals("none")){
                semuaKupon = kuponRepository.findByJenisKuponContaining("DP");
            }

        }
        else if (filter.equals("tanggal_mulai")){
            if(urutan.equals("asc")){
                semuaKupon = kuponRepository.findAllByOrderByTangalMulaiAsc();
            }
            else if(urutan.equals("desc")){
                semuaKupon = kuponRepository.findAllByOrderByTangalMulaiDesc();
            }
        }
        else if (filter.equals("tanggal_selesai")){
            if(urutan.equals("asc")){
                semuaKupon = kuponRepository.findAllByOrderByTanggalSelesaiAsc();
            }
            else if(urutan.equals("desc")){
                semuaKupon = kuponRepository.findAllByOrderByTanggalSelesaiDesc();
            }
        }

        return CompletableFuture.completedFuture(semuaKupon);
    }

}
