package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

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

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Jabatan;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.JenisKelamin;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "karyawan")
public class DataKaryawan {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;
    @Column(name = "nama_lengkap", length = 50)
    private String namaLengkap;
    @Column(name = "jenis_kelamin", length = 50)
    private JenisKelamin jenisKelamin;
    @Column(name = "address", length = 50)
    private String address;
    @Column(name = "no_handphone", length = 50)
    private String noHandphone;
    @Column(name = "pendidikan", length = 50)
    private String pendidikan;
    @Column(name = "hobby", length = 50)
    private String hobby;
    @Column(name = "tangga_join")
    private Date tanggalJoin;
    @Column(name = "jabatan", nullable = false)
    private Jabatan jabatan;
}
