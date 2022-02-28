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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "karyawan")
public class Karyawan {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;

    @Column(name = "nama", length = 50)
    private String nama;

    @Column(name = "jenis_kelamin", length = 20)
    private JenisKelamin jenisKelamin;

    @Column(name = "status_perkawinan", length = 20)
    private StatusPerkawinan statusPerkawinan;

    @Column(name = "no_ktp", length = 20)
    private String noKtp;

    @Column(name = "jabatan")
    private Jabatan jabatan;

    @Column(name = "alamat", length = 100)
    private String alamat;

    @Column(name = "tempat_tanggal_lahir")
    private String tempatTanggalLahir;

    @Column(name = "no_telephone", length = 20)
    private String noTelephone;

    @Column(name = "pendidikan", length = 30)
    private Pendidikan pendidikan;

    @Column(name = "tanggal_join")
    private Date tanggalJoin;
}