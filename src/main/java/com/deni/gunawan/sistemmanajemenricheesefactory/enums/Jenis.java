package com.deni.gunawan.sistemmanajemenricheesefactory.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Jenis {

    ELEKTRONIK("Elektronik"),
    EQUIPMENT("Equipment"),
    UTENSIL("Utensil");

    public final String jenisDisplay;
}
