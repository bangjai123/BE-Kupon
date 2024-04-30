package id.ac.ui.cs.advprog.kupon_bookku.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Kupon" )
@Entity
public abstract class Kupon {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String kode;

    @Column(name = "harga")
    private int harga;

    @Column(name = "nama")
    private String nama;

    @Column(name = "tanggal_mulai")
    private Date tangalMulai;

    @Column(name = "tanggal_selesai")
    private Date tanggalSelesai;

    @Column(name = "status")
    private boolean status;

}
