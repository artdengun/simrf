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
public class TransferPlant {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;
    @NotEmpty(message = "Data Tanggal Dikirim Required")
    @Column(name = "tanggal_dikirim", length = 30)
    private String tanggalDikirim;
    @NotEmpty(message = "Data No Dokumen Required")
    @Column(name = "no_dokumen", length = 30)
    private String noDokumen;
    @NotEmpty(message = "Data Nama Barang Required")
    @Column(name = "nama_barang", length = 30)
    private String namaBarang;
    @NotEmpty(message = "Data Quantity Barang Required")
    @Column(name = "quantity_barang", length = 30)
    private String quantiyBarang;
    @NotEmpty(message = "Data Uom Required")
    @Column(name = "uom", length = 30)
    private String uom;
    @NotEmpty(message = "Data Outlet Penerima Required")
    @Column(name = "outlet_penerima", length = 30)
    private String outletPenerima;
    @NotEmpty(message = "Data Outlet Pengirim Required")
    @Column(name = "outlet_pengirim", length = 30)
    private String outletPengirim;
    @NotEmpty(message = "Data Mod Incharge Required")
    @Column(name = "mod_incharge", length = 30)
    private String modIncharge;

    @ManyToOne
    @JoinColumn(name = "pic", referencedColumnName = "id")
    private Users pic;
}
