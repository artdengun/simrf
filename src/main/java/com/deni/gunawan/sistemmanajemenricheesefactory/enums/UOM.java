package com.deni.gunawan.sistemmanajemenricheesefactory.enums;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author denigunawan
 */

public enum UOM {

    PCS("Pcs"),
    KG("Kg"),
    GR("Gr"),
    PAC("Pac"),
    pail("Pail"),
    ZAK("Zak"),
    ROLL("Roll");

    @Getter
    public final String uomDisplay;

    UOM(String uomDisplay){
        this.uomDisplay = uomDisplay;
    }

}
