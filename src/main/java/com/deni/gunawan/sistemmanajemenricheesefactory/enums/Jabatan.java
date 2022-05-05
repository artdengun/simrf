package com.deni.gunawan.sistemmanajemenricheesefactory.enums;

import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author denigunawan
 */

public enum Jabatan {
    MANAGER("Manager"),
    LEADER("Leader"),
    CREW("Crew");

    @Getter
    public final String jabatanDisplay;

    Jabatan(String jabatanDisplay){
        this.jabatanDisplay = jabatanDisplay;
    }
}
