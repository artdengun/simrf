package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Jabatan;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.JenisKelamin;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Pendidikan;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.StatusPerkawinan;
import lombok.Data;

import org.hibernate.annotations.GenericGenerator;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author denigunawan
 */

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String nama;
    @NotNull
    private String email;
    @NotNull
    private String alamat;
    @NotNull
    private String telephone;
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private JenisKelamin jenisKelamin;
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private StatusPerkawinan statusPerkawinan;
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private Jabatan jabatan;
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private Pendidikan pendidikan;
    private Date tanggalJoin;


}