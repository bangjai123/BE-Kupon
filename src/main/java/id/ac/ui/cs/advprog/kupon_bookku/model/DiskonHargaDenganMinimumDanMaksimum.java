package id.ac.ui.cs.advprog.kupon_bookku.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiskonHargaDenganMinimumDanMaksimum extends Strategy{
    @Override
    public long calculateDiscount(long harga) {
        if(harga > minimumHarga){
            if(potonganHarga > maksimumPotongan){
                return Math.max(harga - maksimumPotongan,0);
            }
            else {
                return Math.max(harga - potonganHarga,0);
            }
        }
        else {
            return harga;
        }
    }
}
