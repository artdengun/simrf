package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Jabatan;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.JenisKelamin;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Pendidikan;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.StatusPerkawinan;
import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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
    @Column(name = "password", length = 254)
    private String password;
    @Column(name = "nama", length = 50)
    private String nama;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "alamat", length = 150)
    private String alamat;
    @Column(name = "telephone", length = 50)
    private String telephone;
    private boolean active = true;

    @Enumerated(EnumType.STRING)
    private JenisKelamin jenisKelamin;

    @Enumerated(value = EnumType.STRING)
    private StatusPerkawinan statusPerkawinan;

    @OneToOne
    @JoinColumn(name = "roleid")
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private Pendidikan pendidikan;
    private String tanggalJoin;

    @OneToMany(mappedBy = "users")
    private List<UserRoles> roles = new ArrayList<>();
}