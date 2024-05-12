package id.ac.ui.cs.advprog.kupon_bookku.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DiskonPersentaseDenganMinimumDanMaksimum extends Strategy{
    @Override
    public long calculateDiscount(long harga) {
        if(harga < minimumHarga){
            return harga;
        }
        else {
            long potongan = (long) (harga * persentase);
            if(potongan > maksimumPotongan){
                return Math.max(harga - maksimumPotongan,0);
            }
            else {
                return Math.max(harga - potongan,1);
            }
        }
    }
}
