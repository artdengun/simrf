package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Jabatan;

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
    @Column(name = "address", length = 50)
    private String address;
    @Column(name = "no_handphone", length = 50)
    private String noHandphone;
    @Column(name = "pendidikan", length = 50)
    private String pendidikan;
    @Column(name = "pengalaman_kerja", length = 50)
    private String pengalamanKerja;
    @Column(name = "description", length = 50)
    private String description;
    @Column(name = "jabatan", nullable = false)
    private Jabatan jabatan;
}
