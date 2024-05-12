package id.ac.ui.cs.advprog.kupon_bookku.model;

import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
import id.ac.ui.cs.advprog.kupon_bookku.repository.KuponRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


import java.util.*;

@SpringBootTest
public class KuponTest {

    private Kupon kuponBaru;

    @Autowired
    private KuponRepository kuponRepository;

    @BeforeEach
    void setUp(){
        this.kuponBaru = new Kupon();
    }

    @Test
    void testCreateKuponEmpty(){
        kuponRepository.save(kuponBaru);

        Kupon kuponTersimpan = kuponRepository.findById(kuponBaru.getId()).get();
        System.out.println("ini id nya: " + kuponTersimpan.getId());
        assertNotNull(kuponTersimpan);

    }

    @Test
    void testEditPotonganKupon(){
//        kuponBaru.setPotonganHarga(0.5);
        assertEquals(kuponBaru.getPotonganHarga(), 0.5);
    }

    @Test
    void testSetTanggalMulaiKuponValid(){
        Calendar myCalendar = new GregorianCalendar(2024, 2, 11);
        Date myDate = myCalendar.getTime();
//        kuponBaru.setTanggalMulai(myDate);
//        assertEquals(kuponBaru.getTanggalMulai(), myDate);
    }

    @Test
    void testSetTanggalMulaiKuponInvalid(){
    }

    @Test
    void testSetTanggalSelesaiKuponInvalid(){
    }

    @Test
    void testSetTanggalSelesaiKuponValid(){
    }

    @Test
    void testSetTanggalKuponSelesaiSebelumMulai(){
    }

    @Test
    void testSetTanggalKuponValid(){
    }

    @Test
    void testSetHargaValid(){
    }

    @Test
    void testSetPotonganHargaInvalid(){
    }

    @Test
    void testSetStatusKupon(){

    }
}
