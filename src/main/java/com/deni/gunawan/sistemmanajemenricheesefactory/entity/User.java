package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.JenisKelamin;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Pendidikan;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.StatusPerkawinan;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;
    private String alamat;
    @Enumerated(EnumType.STRING)
    private JenisKelamin jenisKelamin;
    @Enumerated(EnumType.STRING)
    private Pendidikan pendidikan;
    private String telephone;
    private StatusPerkawinan statusPerkawinan;
    private String tanggalJoin;
    private String email;
    private String username;
    private String password;
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

}
