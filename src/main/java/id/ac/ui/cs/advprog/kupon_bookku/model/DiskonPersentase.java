package id.ac.ui.cs.advprog.kupon_bookku.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DiskonPersentase extends Strategy{
    @Override
    public long calculateDiscount(long price) {
        return Math.max(price-(long) (price * persentase),0);
    }

}
