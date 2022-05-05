package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Jabatan;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.JenisKelamin;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Pendidikan;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.StatusPerkawinan;
import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

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
    @Column(name = "username", length = 50)
    private String username;
    @Column(name = "password", length = 50)
    private String password;
    @Column(name = "nama", length = 50)
    private String nama;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "alamat", length = 50)
    private String alamat;
    @Column(name = "telephone", length = 50)
    private String telephone;

    @Enumerated(EnumType.STRING)
    private JenisKelamin jenisKelamin;

    @Enumerated(value = EnumType.STRING)
    private StatusPerkawinan statusPerkawinan;

    @Enumerated(value = EnumType.STRING)
    private Jabatan jabatan;

    @Enumerated(value = EnumType.STRING)
    private Pendidikan pendidikan;
    private String tanggalJoin;

}