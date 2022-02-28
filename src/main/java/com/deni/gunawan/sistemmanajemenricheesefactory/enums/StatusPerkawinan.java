package com.deni.gunawan.sistemmanajemenricheesefactory.enums;

public enum StatusPerkawinan {
    DUDA("Duda"),
    BELUM_MENIKAH("Belum Menikah"),
    MENIKAH("Menikah"),
    BERPISAH("Berpisah");

    private final String displayStatusPerkawinan;

    private StatusPerkawinan(String displayStatusPerkawinan){
        this.displayStatusPerkawinan = displayStatusPerkawinan;
    }

    public String getDisplayStatusPerkawinan() {
        return displayStatusPerkawinan;
    }
}
