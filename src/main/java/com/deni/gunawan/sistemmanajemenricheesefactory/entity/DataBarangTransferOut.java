package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.UOM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "barang_transfer_out")
public class DataBarangTransferOut {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;
    @Column(name = "tanggal_dikirim", length = 20)
    private Date tanggalDikirim;
    @Column(name = "no_dokumen", length = 50)
    private String noDokumen;
    @Column(name = "nama_barang", length = 20)
    private String namaBarang;
    @Column(name = "quantity_barang", length = 20)
    private String quantiyBarang;
    @Column(name = "uom", length = 20)
    private UOM satuanBarang;
    @Column(name = "jumlah_barang", length = 20)
    private String jumlahBarang;
    @Column(name = "outlet_penerima", length = 20)
    private String outletPenerima;
    @Column(name = "outlet_pengirim", length = 20)
    private String outletPengirim;
    @Column(name = "mod_incharge", length = 20)
    private String modIncharge;
}
