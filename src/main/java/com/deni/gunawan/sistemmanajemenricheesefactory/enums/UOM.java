package com.deni.gunawan.sistemmanajemenricheesefactory.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author denigunawan
 */

@Getter
@AllArgsConstructor
public enum UOM {

    PCS("Pcs"),
    KG("Kg"),
    GR("Gr"),
    PAC("Pac"),
    pail("Pail"),
    ZAK("Zak"),
    ROLL("Roll");

    public final String uomDisplay;

}
