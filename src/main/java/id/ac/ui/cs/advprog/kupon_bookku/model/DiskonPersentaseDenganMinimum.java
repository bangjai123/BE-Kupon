package id.ac.ui.cs.advprog.kupon_bookku.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiskonPersentaseDenganMinimum extends Strategy{
    @Override
    public long calculateDiscount(long harga) {
        if(harga < minimumHarga){
            return harga;
        }
        else {
            return Math.max(harga-(long) (harga * persentase),0);
        }
    }
}
