package id.ac.ui.cs.advprog.kupon_bookku.repository;

import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.Test;

@SpringBootTest
@ActiveProfiles("test")
public class KuponRepositoryTest {

    @Test
    public void createKuponTest(){
        Kupon testKupon = new Kupon();
    }
}

