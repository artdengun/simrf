package com.deni.gunawan.sistemmanajemenricheesefactory.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum Negara {

    INA("Indonesia"),
    AUSI("Australia"),
    THAI("Thailand");

    public final String negaraDisplay;
}
