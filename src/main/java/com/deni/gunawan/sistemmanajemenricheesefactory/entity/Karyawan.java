package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Jabatan;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.JenisKelamin;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Pendidikan;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.StatusPerkawinan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Karyawan {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;
    @NotNull
    private String nama;
    @NotNull
    private String ktp;
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