package id.ac.ui.cs.advprog.kupon_bookku.model;

import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.*;

public class KuponTest {

    private Kupon kuponBaru;

    @BeforeEach
    void setUp(){
        this.kuponBaru = new Kupon();
    }

    @Test
    void testCreateKuponEmpty(){
        assertNotNull(kuponBaru);
    }

    @Test
    void testEditPotonganKupon(){
        kuponBaru.setPotonganHarga(0.5);
        assertEquals(kuponBaru.getPotonganHarga(), 0.5);
    }

    @Test
    void testSetTanggalMulaiKuponValid(){
        Calendar myCalendar = new GregorianCalendar(2024, 2, 11);
        Date myDate = myCalendar.getTime();
        kuponBaru.setTanggalMulai(myDate);
        assertEquals(kuponBaru.getTanggalMulai(), myDate);
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
