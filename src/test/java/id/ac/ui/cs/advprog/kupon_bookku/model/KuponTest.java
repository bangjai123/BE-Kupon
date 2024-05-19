//package id.ac.ui.cs.advprog.kupon_bookku.model;
//
//import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
//import id.ac.ui.cs.advprog.kupon_bookku.repository.KuponRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//import java.util.*;
//
//@SpringBootTest
//public class KuponTest {
//
//    private Kupon kuponBaru;
//
//    @Autowired
//    private KuponRepository kuponRepository;
//
//    @BeforeEach
//    void setUp(){
//        this.kuponBaru = new Kupon();
//    }
//
//    @Test
//    void testCreateKuponEmpty(){
//        assertNull(kuponBaru.getId());
//        assertNull(kuponBaru.getKode());
//        assertNull(kuponBaru.getPotonganHarga());
//        assertEquals(0.0, kuponBaru.getPersentase());
//        assertNull(kuponBaru.getNama());
//        assertNull(kuponBaru.getTangalMulai());
//        assertNull(kuponBaru.getTanggalSelesai());
//        assertFalse(kuponBaru.isStatusKupon());
//        assertNull(kuponBaru.getJenisKupon());
//        assertNull(kuponBaru.getHargaMinimum());
//        assertNull(kuponBaru.getHargaMaksimum());
//    }
//
//    @Test
//    void testEditPotonganKupon(){
//        kuponBaru.setPotonganHarga("10000");
//        assertEquals("10000", kuponBaru.getPotonganHarga());
//    }
//
//    @Test
//    void testSetTanggalMulaiKuponValid(){
//        Date date = new Date();
//        kuponBaru.setTangalMulai(date);
//        assertEquals(date, kuponBaru.getTangalMulai());
//    }
//
//    @Test
//    void testSetTanggalMulaiKuponInvalid(){
//        assertThrows(IllegalArgumentException.class, () -> {
//            kuponBaru.setTangalMulai(null);
//        });
//    }
//
//    @Test
//    void testSetTanggalSelesaiKuponInvalid(){
//        assertThrows(IllegalArgumentException.class, () -> {
//            kuponBaru.setTanggalSelesai(null);
//        });
//    }
//
//    @Test
//    void testSetTanggalSelesaiKuponValid(){
//        Date date = new Date();
//        kuponBaru.setTanggalSelesai(date);
//        assertEquals(date, kuponBaru.getTanggalSelesai());
//    }
//
//    @Test
//    void testSetTanggalKuponSelesaiSebelumMulai(){
//        Date startDate = new Date();
//        Date endDate = new Date(startDate.getTime() - 10000); // 10 seconds before start date
//        kuponBaru.setTangalMulai(startDate);
//        kuponBaru.setTanggalSelesai(endDate);
//        assertFalse(kuponBaru.isValid());
//    }
//
//    @Test
//    void testSetTanggalKuponValid(){
//        Date startDate = new Date();
//        Date endDate = new Date(startDate.getTime() + 10000); // 10 seconds after start date
//        kuponBaru.setTangalMulai(startDate);
//        kuponBaru.setTanggalSelesai(endDate);
//        assertTrue(kuponBaru.isValid());
//    }
//
//    @Test
//    void testSetHargaValid(){
//        kuponBaru.setHargaMinimum(10000);
//        kuponBaru.setHargaMaksimum(20000);
//        assertEquals(10000, kuponBaru.getHargaMinimum());
//        assertEquals(20000, kuponBaru.getHargaMaksimum());
//    }
//
//    @Test
//    void testSetPotonganHargaInvalid(){
//        assertThrows(IllegalArgumentException.class, () -> {
//            kuponBaru.setPotonganHarga(null);
//        });
//    }
//
//    @Test
//    void testSetStatusKupon(){
//        kuponBaru.setStatusKupon(true);
//        assertTrue(kuponBaru.isStatusKupon());
//    }
//}