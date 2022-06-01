package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Negara;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.UOM;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Vendor;
import lombok.Data;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

import javax.validation.constraints.NotEmpty;

/**
 *
 * @author denigunawan
 */

@Entity
@Data
public class Retur {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;
    @NotEmpty(message = "Data Nama Barang Required")
    @Column(name = "nama_barang", length = 50)
    private String namaBarang;
    @NotEmpty(message = "Data Production Date Required")
    @Column(name = "production_date", length = 30)
    private String productionDate;
    @NotEmpty(message = "Data Expdate Required")
    @Column(name = "exp_date", length = 30)
    private String expDate;
    @NotEmpty(message = "Data Jumlah Retur Required")
    @Column(name = "jumlah_retur", length = 30)
    private String jumlahRetur;
    @NotEmpty(message = "Data Code Barang Required")
    @Column(name = "code_barang", length = 30)
    private String codeBarang;
    @NotEmpty(message = "Data Tanggal Retur Required")
    @Column(name = "tanggal_retur")
    private String tanggalRetur;
    @NotEmpty(message = "Data Deskripsi Required")
    @Column(name = "deskripsi", length = 100)
    private String deskripsi;


    @Enumerated(EnumType.STRING)
    private Vendor vendor;

    @Enumerated(EnumType.STRING)
    private Negara negara;

    @Enumerated(EnumType.STRING)
    private UOM uom;
//    @OneToOne
//    @JoinColumn(name = "userid")
//    private Users users;
}
