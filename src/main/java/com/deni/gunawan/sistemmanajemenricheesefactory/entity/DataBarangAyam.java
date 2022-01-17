package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.UOM;
import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Vendor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "barang_ayam")
public class DataBarangAyam {

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
    private Date productionDate;
    @Column(name = "exp_date")
    private Date expDate;
    @Column(name = "uom")
    private UOM uom;
    @Column(name = "code_kemasan", length = 10)
    private String codeKemasan;
    @Column(name = "quantity_batch", length = 20)
    private String quantityBatch;
    @Column(name = "quantity_pcs", length = 20)
    private String quantityPcs;
    @Column(name = "weight", length = 50)
    private String weight;
    @Column(name = "tanggal_penerimaan")
    private Date tanggalPenerimaan;
    @Column(name = "deskripsi", length = 100)
    private String deskripsi;
    @ManyToOne
    @JoinColumn(name = "pic", nullable = false)
    private DataKaryawan pic;
    @CreationTimestamp
    @Column(name = "created_date")
    private Timestamp createdDate;
    @UpdateTimestamp
    @Column(name = "update_date")
    private Timestamp updateDate;
}
