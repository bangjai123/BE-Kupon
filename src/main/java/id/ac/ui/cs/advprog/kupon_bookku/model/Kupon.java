package id.ac.ui.cs.advprog.kupon_bookku.model;

import id.ac.ui.cs.advprog.kupon_bookku.enums.JenisKupon;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Table(name = "Kupon" )
@Entity
@Getter
public class Kupon {
    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.UUID)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "kode")
    private String kode;

    @Column(name = "potongan_harga")
    private String potonganHarga;

    @Column(name = "persentase")
    private double persentase;

    @Column(name = "nama")
    private String nama;

    @Column(name = "tanggal_mulai")
    private Date tangalMulai;

    @Column(name = "tanggal_selesai")
    private Date tanggalSelesai;

    @Column(name = "status_kupon")
    private boolean statusKupon;

    @Column(name = "jenis_kupon")
    private String jenisKupon;

    @Column(name = "harga_minimum")
    private Integer hargaMinimum;

    @Column(name = "harga_maksimum")
    private Integer hargaMaksimum;

    public boolean isValid(){
        Date today = new Date();
        return !tangalMulai.after(today) && !tanggalSelesai.before(today);
    }

    public boolean getStatusKupon(){
        return statusKupon;
    }
}
