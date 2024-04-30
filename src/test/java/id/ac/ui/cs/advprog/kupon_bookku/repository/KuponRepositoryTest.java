package id.ac.ui.cs.advprog.kupon_bookku.repository;

import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.jupiter.api.Test;

@SpringBootTest
@ActiveProfiles("test")
public class KuponRepositoryTest {

    @Test
    public void createKuponTest(){
        Kupon testKupon = new Kupon();
    }
}

