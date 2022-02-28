package com.deni.gunawan.sistemmanajemenricheesefactory.enums;

public enum Vendor {
    CIOMAS("Ciomas"),
    DC_BEKASI("DC Bekasi"),
    DC_BANDUNG("DC Bandung"),
    DC_SURABAYA("DC Surabaya");


    private final String displayVendor;

    private Vendor(String displayVendor){
        this.displayVendor = displayVendor;
    }

    public String getDisplayVendor() {
        return displayVendor;
    }
}
