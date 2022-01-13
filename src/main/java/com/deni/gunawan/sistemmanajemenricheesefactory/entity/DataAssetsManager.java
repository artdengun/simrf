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
import javax.persistence.Table;

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.TypeAssets;

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
    @Column(name = "pengirim", length = 50)
    private String pengirim;
    @Column(name = "tanggal_diterima")
    private Date tanggalDiterima;
    @Column(name = "type_assets", length = 50)
    private TypeAssets typeAssets = TypeAssets.LOBBY;
    @Column(name = "nama", length = 50)
    private String nama;
    @Column(name = "jenis", length = 50)
    private String jenis;
    @Column(name = "quantity", length = 50)
    private String quantity;
    @Column(name = "harga_assets", length = 50)
    private BigDecimal hargaAssets;
    @Column(name = "penerima", length = 50)
    private String penerima;
    @Column(name = "pic", length = 50)
    private String pic;

    @CreationTimestamp
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp updateDate;

}
