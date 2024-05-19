package id.ac.ui.cs.advprog.kupon_bookku.service;


import id.ac.ui.cs.advprog.kupon_bookku.enums.JenisKupon;
import id.ac.ui.cs.advprog.kupon_bookku.model.*;
import id.ac.ui.cs.advprog.kupon_bookku.repository.KuponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

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
    public Kupon createKupon(Kupon kupon) {
        kuponRepository.save(kupon);
        return kupon;
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
    public void editKupon(String kuponId, Kupon kuponBaru) {
        Optional<Kupon> diubah = kuponRepository.findById(kuponId);
        if(diubah.isPresent()){
            Kupon kuponDiubah = diubah.get();
            kuponDiubah.setKode(kuponBaru.getKode());
            kuponDiubah.setJenisKupon(kuponBaru.getJenisKupon());
            kuponDiubah.setPotonganHarga(kuponBaru.getPotonganHarga());
            kuponDiubah.setTanggalSelesai(kuponBaru.getTanggalSelesai());
            kuponRepository.save(kuponDiubah);
        }
    }

    @Override
    public void deleteKupon(String kuponId) {
        if(kuponRepository.findById(kuponId).isPresent()){
            kuponRepository.delete(kuponRepository.findById(kuponId).get());
        }
    }
    @Override
    public Kupon findKuponByKode(String kodeKupon) {
        if(kuponRepository.findByKode(kodeKupon).isPresent()) {
            return kuponRepository.findByKode(kodeKupon).get();
        }
        else return null;
    }

    @Override
    public String gunakanKupon(String kodeKupon, String hargaAwal) {
        Optional<Kupon> kuponDicari = kuponRepository.findByKode(kodeKupon);
        if(kuponDicari.isPresent() && kuponDicari.get().isValid()){
            Kupon kuponDigunakan = kuponDicari.get();
            Strategy strategy = strategyMap.get(kuponDigunakan.getJenisKupon());
            strategy.setPersentase(kuponDigunakan.getPersentase());
            strategy.setMinimumHarga(kuponDigunakan.getHargaMinimum());
            strategy.setMaksimumPotongan(kuponDigunakan.getHargaMaksimum());
            strategy.setPotonganHarga(Long.parseLong(kuponDigunakan.getPotonganHarga()));
            long hargaAkhir = strategy.calculateDiscount(Long.parseLong(hargaAwal));
            return "" + hargaAkhir;
        }
        return "Kupon tidak valid "+kuponDicari.get().isValid();
    }
}
