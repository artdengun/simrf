package com.deni.gunawan.sistemmanajemenricheesefactory.enums;

import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author denigunawan
 */

public enum Pendidikan {
    SD("SD"),
    SMP("SMP"),
    SMA("SMA"),
    SMK("SMK"),
    SARJANA("SARJANA"),
    MAGISTER("MAGISTER"),
    DR("DR");

    @Getter
    public final String pendidikanDisplay;

     Pendidikan(String pendidikanDisplay){
        this.pendidikanDisplay = pendidikanDisplay;
    }
}
