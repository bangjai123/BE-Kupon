package id.ac.ui.cs.advprog.kupon_bookku.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Strategy {
    public double persentase;
    protected long potonganHarga;
    protected long minimumHarga;
    protected long maksimumPotongan;
    public abstract long calculateDiscount(long harga);
}
