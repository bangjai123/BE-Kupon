package id.ac.ui.cs.advprog.kupon_bookku.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiskonPersentaseDenganMaksimum extends Strategy {
    @Override
    public long calculateDiscount(long price) {
        long potongan = (long) (price * persentase);
        if(potongan > maksimumPotongan){
            return Math.max(price - maksimumPotongan,0);
        }
        else {
            return Math.max(price - potongan,0);
        }
    }
}
