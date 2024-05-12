package id.ac.ui.cs.advprog.kupon_bookku.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum JenisKupon {
    DISKONHARGA("DH"),
    DISKONHARGADENGANMAKSIMUM("DHMAKS"),
    DISKONHARGADENGANMINIMUM("DHMIN"),
    DISKONHARGADENGANMINMUMDANMAKSIMUM("DHMINMAKS"),
    DISKONPERSENTASE("DP"),
    DISKONPERSENTASEDENGANMAKSIMUM("DPMAKS"),
    DISKONPERSENTASEDENGANMINIMUM("DPMIN"),
    DISKONPERSENTASEDENGANMINIMUMDANMAKSIMUM("DPMINMKAS");

    private final String value;
    private JenisKupon(String value){
        this.value = value;
    }

    public static boolean contains(String param) {
        for (JenisKupon jenisKupon: JenisKupon.values()) {
            if (jenisKupon.name().equals(param)) {
                return true;
            }
        }
        return false;
    }

}
