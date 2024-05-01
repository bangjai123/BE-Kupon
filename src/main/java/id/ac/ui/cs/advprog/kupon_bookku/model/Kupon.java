package id.ac.ui.cs.advprog.kupon_bookku.model;

import id.ac.ui.cs.advprog.kupon_bookku.enums.JenisKupon;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;


@Getter
@Setter
@Table(name = "Kupon" )
@Entity
public class Kupon {
    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.UUID)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "kode")
    private String kode;

    @Column(name = "potongan_harga")
    private String potonganHarga;

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

    public Kupon(){}

    public Kupon(String nama, String potonganHarga, Date tangalMulai, Date tanggalSelesai, boolean statusKupon){
        this.nama = nama;
        this.potonganHarga = potonganHarga;
        this.tangalMulai = tangalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.statusKupon = statusKupon;
        this.jenisKupon = JenisKupon.DISKONHARGA.getValue();
    }


 }
