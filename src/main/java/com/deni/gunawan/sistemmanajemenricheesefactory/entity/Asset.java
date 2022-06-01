package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Jenis;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Vendor;
import lombok.*;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 *
 * @author denigunawan
 */

@Entity
@Data
public class Asset {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @NotEmpty(message = "Data No Assets Required")
    @Column(name = "no_assets", length = 30)
    private String noAssets;
    @NotEmpty(message = "Data Tanggal Diterima Required")
    @Column(name = "tanggal_diterima", length = 30)
    private String tanggalDiterima;
    @NotEmpty(message = "Data Nama Barang Required")
    @Column(name = "nama", length = 30)
    private String nama;
    @NotEmpty(message = "Data Quantity Barang Required")
    @Column(name = "quantity", length = 30)
    private String quantity;
    @NotNull(message = "Data Harga Assets Required")
    @Min(value = 10, message = "Inputkan Berdasarkan Harga")
    @Column(name = "harga_assets", length = 50)
    private BigDecimal hargaAssets;
    @NotEmpty(message = "Data Tanggal Input Required")
    @Column(name = "tanggal_input", length = 30)
    private String tanggalInput;

    @Enumerated(EnumType.STRING)
    private Vendor vendor;

    @Enumerated(EnumType.STRING)
    private Jenis jenis;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User users;
}
