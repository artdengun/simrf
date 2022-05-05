package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @NotEmpty(message = "Data Vendor Required")
    @Column(name = "vendor", nullable = false, length = 30)
    private String vendor;
    @NotEmpty(message = "Data Nama Barang Required")
    @Column(name = "nama_barang", length = 50)
    private String namaBarang;
    @NotEmpty(message = "Data Production Date Required")
    @Column(name = "production_date", length = 30)
    private String productionDate;
    @NotEmpty(message = "Data Expdate Required")
    @Column(name = "exp_date", length = 30)
    private String expDate;
    @NotEmpty(message = "Data Pic Required")
    @Column(name = "pic", length = 30)
    private String pic;
    @NotEmpty(message = "Data Negara Required")
    @Column(name = "negara", length = 30)
    private String negara;
    @NotEmpty(message = "Data Jumlah Retur Required")
    @Column(name = "jumlah_retur", length = 30)
    private String jumlahRetur;
    @NotEmpty(message = "Data Uom Required")
    @Column(name = "uom", nullable = false, length = 30)
    private String uom;
    @NotEmpty(message = "Data Code Barang Required")
    @Column(name = "code_barang", length = 30)
    private String codeBarang;
    @NotEmpty(message = "Data Tanggal Retur Required")
    @Column(name = "tanggal_retur")
    private String tanggalRetur;
    @NotEmpty(message = "Data Deskripsi Required")
    @Column(name = "deskripsi", length = 100)
    private String deskripsi;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private Users userid;
}
