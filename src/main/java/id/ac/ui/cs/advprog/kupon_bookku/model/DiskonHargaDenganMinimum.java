package id.ac.ui.cs.advprog.kupon_bookku.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DiskonHargaDenganMinimum extends Strategy{
    @Override
    public long calculateDiscount(long harga) {
        if(harga > minimumHarga){
            return Math.max(harga - potonganHarga,0);
        }
        else {
            return harga;
        }
    }
}
