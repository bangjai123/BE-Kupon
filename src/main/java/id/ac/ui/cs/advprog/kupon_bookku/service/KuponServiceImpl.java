package id.ac.ui.cs.advprog.kupon_bookku.service;

import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
import id.ac.ui.cs.advprog.kupon_bookku.repository.KuponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KuponServiceImpl implements  KuponService {
    @Autowired
    private KuponRepository kuponRepository;
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
    public List<Kupon> getAllKupon() {
        List<Kupon> semuaKupon = kuponRepository.findAll();
        return semuaKupon;
    }

    @Override
    public void editKupon(String kuponId, Kupon kuponBaru) {
        Optional<Kupon> diubah = kuponRepository.findById(kuponId);
        if(diubah.isPresent()){
            Kupon kuponDiubah = diubah.get();
//            kuponDiubah.editKupon(kuponBaru);
        }

    }

    @Override
    public void deleteKupon(String kuponId) {

    }
    @Override
    public Kupon findKuponByKode(String kuponId) {
        return null;
    }

    @Override
    public String gunakanKupon(Kupon kuponDigunakan, String hargaAwal) {
        return null;
    }

    public KuponRepository getKuponRepository() {
        return kuponRepository;
    }

    public void setKuponRepository(KuponRepository kuponRepository) {
        this.kuponRepository = kuponRepository;
    }
}
