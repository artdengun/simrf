package com.deni.gunawan.sistemmanajemenricheesefactory.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum Jenis {

    ELEKTRONIK("Elektronik"),
    EQUIPMENT("Equipment"),
    UTENSIL("Utensil");

    public final String jenisDisplay;
}
