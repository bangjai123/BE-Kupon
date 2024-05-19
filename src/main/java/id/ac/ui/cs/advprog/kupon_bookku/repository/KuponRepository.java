package id.ac.ui.cs.advprog.kupon_bookku.repository;

import id.ac.ui.cs.advprog.kupon_bookku.model.Kupon;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface KuponRepository extends JpaRepository<Kupon,String>{
    Optional<Kupon> findByKode(String kode);
    List<Kupon> findAllByOrderByTangalMulaiAsc();
    List<Kupon> findAllByOrderByTangalMulaiDesc();
    List<Kupon> findAllByOrderByTanggalSelesaiAsc();
    List<Kupon> findAllByOrderByTanggalSelesaiDesc();
    List<Kupon> findByJenisKuponContainingOrderByPotonganHargaAsc(String jenisKupon);
    List<Kupon> findByJenisKuponContaining(String jenisKupon);
    List<Kupon> findByJenisKuponContainingOrderByPotonganHargaDesc(String jenisKupon);
    List<Kupon> findByJenisKuponContainingOrderByPersentaseAsc(String jenisKupon);
    List<Kupon> findByJenisKuponContainingOrderByPersentaseDesc(String jenisKupon);
}
