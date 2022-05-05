package com.deni.gunawan.sistemmanajemenricheesefactory.enums;

import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author denigunawan
 */

public enum JenisKelamin {
    LAKI_LAKI("Laki Laki"),
    PEREMPUAN("Perempuan");

    @Getter
    public final String jenisKelaminDisplay;

    JenisKelamin(String jenisKelaminDisplay){
        this.jenisKelaminDisplay = jenisKelaminDisplay;
    }
}
