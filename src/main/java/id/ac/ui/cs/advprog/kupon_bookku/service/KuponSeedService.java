package id.ac.ui.cs.advprog.kupon_bookku.service;

import id.ac.ui.cs.advprog.kupon_bookku.enums.JenisKupon;
import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
import id.ac.ui.cs.advprog.kupon_bookku.repository.KuponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
public class KuponSeedService {
    @Autowired
    KuponRepository kuponRepository;
    public void seedKupon() {
        Random random = new Random();
        Calendar cal = Calendar.getInstance();
        for (int i = 1; i <= 50; i++) {
            Kupon kupon = new Kupon();
            int randomNum = random.nextInt(90000) + 10000;
            kupon.setKode("kupon" + i + "-" + randomNum);
            char alphabet = (char) ((50 % 26) + 1 + 'a');
            kupon.setNama("kupon-" + alphabet + "-" + i);
            JenisKupon jenisKupon = JenisKupon.values()[i % JenisKupon.values().length];
            kupon.setJenisKupon(jenisKupon.getValue());
            if (jenisKupon.name().contains("PERSENTASE")) {
                kupon.setPersentase(random.nextDouble(1.0));
                kupon.setPotonganHarga(String.valueOf(0));
            } else {
                kupon.setPotonganHarga(String.valueOf(random.nextInt(10000)));
                kupon.setPersentase(0);
            }
            if (jenisKupon.name().contains("MINIMUM")) {
                kupon.setHargaMinimum(random.nextInt(10000));
            } else {
                kupon.setHargaMinimum(0);
            }
            if (jenisKupon.name().contains("MAKSIMUM")) {
                kupon.setHargaMaksimum(random.nextInt(10000));
            } else {
                kupon.setHargaMaksimum(Integer.MAX_VALUE);
            }
            kupon.setStatusKupon(true);


            cal.set(Calendar.YEAR, 2022);
            cal.set(Calendar.MONTH, Calendar.JULY);
            cal.set(Calendar.DAY_OF_MONTH, 15);
            Date startDate = cal.getTime();
            long startMillis = startDate.getTime();
            long endMillis = System.currentTimeMillis();
            long randomMillis = startMillis + (long) (random.nextDouble() * (endMillis - startMillis));
            Date tanggalMulai = new Date(randomMillis);
            kupon.setTangalMulai(tanggalMulai);


            cal.setTime(tanggalMulai);
            cal.add(Calendar.DAY_OF_MONTH, random.nextInt(365));
            Date tanggalSelesai = cal.getTime();
            kupon.setTanggalSelesai(tanggalSelesai);

            kuponRepository.save(kupon);
        }
    }
}
