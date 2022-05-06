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
public enum StatusPerkawinan {
    DUDA("Duda"),
    BELUM_MENIKAH("Belum Menikah"),
    MENIKAH("Menikah"),
    BERPISAH("Berpisah");

    public final String statusPerkawinanDisplay;

}
