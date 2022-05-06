package com.deni.gunawan.sistemmanajemenricheesefactory.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Vendor {

    PT_CIOMAS("PT Ciomas Adisatwa"),
    PT_KERRY("PT Kerry Ingridients"),
    PT_RICHEESE("PT Richeese Kuliner Indonesia"),
    PT_DELISARI("PT Delisari Nusantara"),
    PT_SINARMAS("PT Sinarmas Agro Resource");

    public final String vendorDisplay;

}
