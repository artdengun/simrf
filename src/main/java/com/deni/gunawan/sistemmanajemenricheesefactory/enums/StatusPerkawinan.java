package com.deni.gunawan.sistemmanajemenricheesefactory.enums;

import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author denigunawan
 */

public enum StatusPerkawinan {
    DUDA("Duda"),
    BELUM_MENIKAH("Belum Menikah"),
    MENIKAH("Menikah"),
    BERPISAH("Berpisah");

    @Getter
    public final String statusPerkawinanDisplay;

     StatusPerkawinan(String statusPerkawinanDisplay){
        this.statusPerkawinanDisplay = statusPerkawinanDisplay;
    }
}
