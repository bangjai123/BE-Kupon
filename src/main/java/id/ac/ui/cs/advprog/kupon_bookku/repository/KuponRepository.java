package id.ac.ui.cs.advprog.kupon_bookku.repository;

import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface KuponRepository extends JpaRepository<Kupon,String>{
    public Optional<Kupon> findByKode(String kode);
}
