package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.UOM;
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
@Table(name = "barang_raw")
public class DataBarangRaw {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;
    @Column(name = "vendor", nullable = false)
    private Vendor vendor;
    @Column(name = "nama_product", length = 50)
    private String namaProduct;
    @Column(name = "production_date")
    private java.sql.Date productionDate;
    @Column(name = "exp_date")
    private java.sql.Date expDate;
    @Column(name = "negara")
    private String negara;
    @Column(name = "uom", nullable = false)
    private UOM uom;
    @Column(name = "codeBarang", length = 10)
    private String codeBarang;
    @Column(name = "tanggal_penerimaan")
    private java.sql.Date tanggalPenerimaan;
    @Column(name = "deskripsi", length = 100)
    private String deskripsi;
    @ManyToOne
    @JoinColumn(name = "id_karyawan", referencedColumnName = "id")
    private DataKaryawan dataKaryawan;

}
