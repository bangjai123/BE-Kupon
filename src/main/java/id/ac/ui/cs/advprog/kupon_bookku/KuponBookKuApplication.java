package id.ac.ui.cs.advprog.kupon_bookku;

import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication()
@EnableAsync
public class KuponBookKuApplication {

    public static void main(String[] args) {
        SpringApplication.run(KuponBookKuApplication.class, args);
    }

}
