package com.deni.gunawan.sistemmanajemenricheesefactory.enums;

/**
 *
 * @author denigunawan
 */

public enum Jabatan {
    STORE_MANAGER("Store Manager"),
    ASSITEN_MANAGER("Assisten Manager"),
    LEADER("Leader"),
    CREW("Crew");

    private final String displayJabatan;

    private Jabatan(String displayJabatan){
        this.displayJabatan = displayJabatan;
    }

    public String getDisplayJabatan(){
        return displayJabatan;
    }
}
