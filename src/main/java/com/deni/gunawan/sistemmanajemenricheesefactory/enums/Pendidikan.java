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
public enum Pendidikan {
    SD("SD"),
    SMP("SMP"),
    SMA("SMA"),
    SMK("SMK"),
    SARJANA("SARJANA"),
    MAGISTER("MAGISTER"),
    DR("DR");

    public final String pendidikanDisplay;

}
