package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name = "dokumen_keluar")
public class DataDokumenKeluar {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;
    @ManyToOne
    @JoinColumn(name = "vendor", nullable = false)
    private DataTypeVendor vendor;
    @Column(name = "nama_product", length = 50)
    private String namaDokumen;
    @ManyToOne
    @JoinColumn(name = "type_documets")
    private DataTypeDocuments typeDocuments;
    @Column(name = "code_dokumen", length = 10)
    private String codeDokumen;
    @Column(name = "jumlah_document")
    private String jumlahDocument;
    @Column(name = "tanggal_pengiriman")
    private Date tanggal_pengiriman;
    @ManyToOne
    @JoinColumn(name = "pengirim", nullable = false)
    private DataKaryawan pengirim;
    @Column(name = "penerima")
    private String penerima;
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
