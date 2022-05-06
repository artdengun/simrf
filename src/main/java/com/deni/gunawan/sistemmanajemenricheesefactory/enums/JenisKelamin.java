package com.deni.gunawan.sistemmanajemenricheesefactory.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author denigunawan
 */

@Getter
@AllArgsConstructor
public enum JenisKelamin {

    LAKI_LAKI("Laki Laki"),
    PEREMPUAN("Perempuan");

    public final String jenisKelaminDisplay;

}
