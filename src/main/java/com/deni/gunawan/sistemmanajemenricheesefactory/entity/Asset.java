package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Vendor;

@Entity
@Data
public class Asset {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;
    @Column(name = "no_assets", length = 50)
    private String noAssets;
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private Vendor vendor;
    @NotNull
    private Date tanggalDiterima;
    @NotNull
    private String nama;
    @NotNull
    private String jenis;
    @NotNull
    private String quantity;
    @NotNull
    private BigDecimal hargaAssets;
    @Column(name = "tanggal_input")
    private Date tanggalInput;
    
    @ManyToOne
    @JoinColumn(name = "id_karyawan", referencedColumnName = "id")
    private Karyawan karyawan;
}
