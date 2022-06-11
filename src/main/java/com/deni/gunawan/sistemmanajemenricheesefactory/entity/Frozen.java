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
public class Frozen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Data Product Required")
    @Column(length = 50)
    private String namaProduct;
    @NotEmpty(message = "Data Suhu Product Required")
    @Column(length = 10)
    private String suhuProduct;
    @NotEmpty(message = "Data Production Date Required")
    @Column(length = 30)
    private String productionDate;
    @NotEmpty(message = "Data Expdate Required")
    @Column(length = 30)
    private String expDate;
    @NotEmpty(message = "Data Quantity Barang Required")
    @Column(name = "quantity", length = 30)
    private String quantity;
    @NotEmpty(message = "Data Code Barang Required")
    @Column(name = "codeBarang", length = 30)
    private String codeBarang;
    @NotEmpty(message = "Data Tanggal Penerimaan Required")
    @Column(name = "tanggal_penerimaan", length = 30)
    private String tanggalPenerimaan;
    @NotEmpty(message = "Data Deskripsi Required")
    @Column(name = "deskripsi", length = 100)
    private String deskripsi;

    @Enumerated(EnumType.STRING)
    private Vendor vendor;

    @Enumerated(EnumType.STRING)
    private Negara negara;

    @Enumerated(EnumType.STRING)
    private UOM uom;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User users;
}
