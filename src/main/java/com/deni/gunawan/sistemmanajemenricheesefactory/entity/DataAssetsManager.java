package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "assets_manager")
public class DataAssetsManager {

    @Id
    @GeneratedValue(generator = "assets-manager")
    @GenericGenerator(name = "assets-manager", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;
    @Column(name = "no_assets", length = 50)
    private String noAssets;
    @ManyToOne
    @JoinColumn(name = "vendor", nullable = false)
    private DataTypeVendor vendor;
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
    @ManyToOne
    @JoinColumn(name = "pic", nullable = false)
    private DataKaryawan pic;
    @CreationTimestamp
    @Column(name = "created_date")
    private Timestamp createdDate;
    @UpdateTimestamp
    @Column(name = "update_date")
    private Timestamp updateDate;
    @ManyToOne
    @JoinColumn(name = "type_assets", nullable = false)
    private DataTypeAssets typeAssets;
}
