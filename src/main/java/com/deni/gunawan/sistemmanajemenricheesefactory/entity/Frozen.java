package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;

/**
 *
 * @author denigunawan
 */

@Entity
@Data
public class Frozen {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;
    @NotEmpty(message = "Data Vendor Required")
    @Column(name = "vendor", nullable = false, length = 30)
    private String vendor;
    @NotEmpty(message = "Data Product Required")
    @Column(name = "nama_product", length = 50)
    private String namaProduct;
    @NotEmpty(message = "Data Suhu Product Required")
    @Column(name = "suhu_product", length = 10)
    private String suhuProduct;
    @NotEmpty(message = "Data Production Date Required")
    @Column(name = "production_date", length = 30)
    private String productionDate;
    @NotEmpty(message = "Data Expdate Required")
    @Column(name = "exp_date", length = 30)
    private String expDate;
    @NotEmpty(message = "Data Negara Required")
    @Column(name = "negara", length = 30)
    private String negara;
    @NotEmpty(message = "Data UOM Required")
    @Column(name = "uom", nullable = false, length = 40)
    private String uom;
    @NotEmpty(message = "Data PIC Required")
    @Column(name = "pic", length = 50)
    private String pic;
    @NotEmpty(message = "Data Code Barang Required")
    @Column(name = "codeBarang", length = 30)
    private String codeBarang;
    @NotEmpty(message = "Data Tanggal Penerimaan Required")
    @Column(name = "tanggal_penerimaan", length = 30)
    private String tanggalPenerimaan;
    @NotEmpty(message = "Data Deskripsi Required")
    @Column(name = "deskripsi", length = 100)
    private String deskripsi;
}
