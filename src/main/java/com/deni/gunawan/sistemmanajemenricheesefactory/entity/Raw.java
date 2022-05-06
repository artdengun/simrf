package com.deni.gunawan.sistemmanajemenricheesefactory.entity;


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
public class Raw {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;
    @NotEmpty(message = "Data Vendor Required")
    @Column(name = "vendor", nullable = false, length = 30)
    private String vendor;
    @NotEmpty(message = "Data Nama Product Required")
    @Column(name = "nama_product", length = 50)
    private String namaProduct;
    @NotEmpty(message = "Data Production Date Required")
    @Column(name = "production_date", length = 30)
    private String productionDate;
    @NotEmpty(message = "Data Expdate Required")
    @Column(name = "exp_date", length = 30)
    private String expDate;
    @NotEmpty(message = "Data Negara Required")
    @Column(name = "negara", length = 30)
    private String negara;
    @NotEmpty(message = "Data Uom Required")
    @Column(name = "uom", nullable = false, length = 30)
    private String uom;
    @NotEmpty(message = "Data Quantity Barang Required")
    @Column(name = "quantity", length = 30)
    private String quantity;
    @NotEmpty(message = "Data Code Barang Required")
    @Column(name = "codeBarang", length = 30)
    private String codeBarang;
    @NotEmpty(message = "Data Tanggal Penerimaan Required")
    @Column(name = "tanggal_penerimaan")
    private String tanggalPenerimaan;
    @NotEmpty(message = "Data Deskripsi Required")
    @Column(name = "deskripsi", length = 100)
    private String deskripsi;

    @ManyToOne
    @JoinColumn(name = "pic", referencedColumnName = "id")
    private Users pic;
}
