package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Vendor;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "barang_asset")
public class DataBarangAsset {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;
    @Column(name = "no_assets", length = 50)
    private String noAssets;
    @Column(name = "vendor", nullable = false)
    private Vendor vendor;
    @Column(name = "tanggal_diterima")
    private Date tanggalDiterima;
    @Column(name = "nama", length = 50)
    private String nama;
    @Column(name = "jenis", length = 50)
    private String jenis;
    @Column(name = "quantity", length = 50)
    private String quantity;
    @Column(name = "harga_assets", length = 50)
    private BigDecimal hargaAssets;
    @Column(name = "tanggal_input")
    private Date tanggalInput;
    
    @ManyToOne
    @JoinColumn(name = "id_karyawan", referencedColumnName = "id")
    private DataKaryawan dataKaryawan;
}
