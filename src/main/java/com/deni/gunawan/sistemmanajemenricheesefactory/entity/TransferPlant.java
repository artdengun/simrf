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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author denigunawan
 */

@Entity
@Data
public class TransferPlant {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuids", strategy = "uuid2")
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
    private UOM uom;
    @NotNull
    private String pic;
    @Column(name = "outlet_penerima", length = 20)
    private String outletPenerima;
    @Column(name = "outlet_pengirim", length = 20)
    private String outletPengirim;
    @Column(name = "mod_incharge", length = 20)
    private String modIncharge;
}
