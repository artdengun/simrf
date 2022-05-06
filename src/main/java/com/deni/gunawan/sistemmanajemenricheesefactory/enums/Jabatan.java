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
public enum Jabatan {
    MANAGER("Manager"),
    LEADER("Leader"),
    CREW("Crew");

    public final String jabatanDisplay;

}
