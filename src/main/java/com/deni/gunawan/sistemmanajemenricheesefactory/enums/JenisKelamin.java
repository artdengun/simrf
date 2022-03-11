package com.deni.gunawan.sistemmanajemenricheesefactory.enums;

/**
 *
 * @author denigunawan
 */

public enum JenisKelamin {
    LAKI_LAKI("Laki Laki"),
    PEREMPUAN("Perempuan");

    private final String displayJK;

    private JenisKelamin(String displayJK){
        this.displayJK = displayJK;
    }

    public String getDisplayJK(){
        return  displayJK;
    }
}
