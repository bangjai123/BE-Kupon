//package id.ac.ui.cs.advprog.kupon_bookku.repository;
//
//import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class KuponRepositoryTest {
//
//    @Autowired
//    private KuponRepository kuponRepository;
//
//    private Kupon testKupon;
//
//    @BeforeEach
//    public void setup() {
//        testKupon = new Kupon();
//        kuponRepository.save(testKupon);
//    }
//
//    @Test
//    public void saveKuponTest(){
//        Kupon newKupon = new Kupon();
//        Kupon savedKupon = kuponRepository.save(newKupon);
//        assertNotNull(savedKupon.getId());
//    }
//
//    @Test
//    public void editKuponTest(){
//        kuponRepository.save(testKupon);
//        Kupon updatedKupon = kuponRepository.findById(testKupon.getId()).orElse(null);
//    }
//
//    @Test
//    public void deleteKuponTest(){
//        kuponRepository.delete(testKupon);
//        Kupon deletedKupon = kuponRepository.findById(testKupon.getId()).orElse(null);
//        assertNull(deletedKupon);
//    }
//
//    @Test
//    public void getAllKuponTest(){
//        Iterable<Kupon> kupons = kuponRepository.findAll();
//        assertNotNull(kupons);
//    }
//
//    @Test
//    public void findKuponByIdTest(){
//        Optional<Kupon> foundKupon = kuponRepository.findById(testKupon.getId());
//        assertTrue(foundKupon.isPresent());
//        assertEquals(testKupon.getId(), foundKupon.get().getId());
//    }
//}