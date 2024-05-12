package id.ac.ui.cs.advprog.kupon_bookku.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiskonHargaDenganMaksimum extends Strategy {
    @Override
    public long calculateDiscount(long harga) {
        if(potonganHarga > maksimumPotongan){
            return Math.max(harga - maksimumPotongan,0);
        }
        else {
            return Math.max(harga - potonganHarga,0);
        }
    }
}
