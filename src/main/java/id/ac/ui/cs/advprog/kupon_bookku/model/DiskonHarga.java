package id.ac.ui.cs.advprog.kupon_bookku.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiskonHarga extends Strategy{
    @Override
    public long calculateDiscount(long harga) {
        return Math.max(harga - potonganHarga,0);
    }
}
