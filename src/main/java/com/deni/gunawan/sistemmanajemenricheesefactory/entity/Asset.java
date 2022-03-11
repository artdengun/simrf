package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.deni.gunawan.sistemmanajemenricheesefactory.enums.Vendor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author denigunawan
 */

@Entity
@Data
public class Asset {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @NotEmpty(message = "No Assets Harus Diinputkan")
    @Column(name = "no_assets", length = 50)
    private String noAssets;
    @NotEmpty(message = "Vendor Harus Dinputkan")
    private String vendor;
    @NotEmpty(message = "Nama Pic Harus Diinputkan")
    private String pic;
    @NotNull(message = "Tanggal Diterima harus Diinputkan")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date tanggalDiterima;
    @NotEmpty(message = "Nama Barang Harus Diinputkan")
    private String nama;
    @NotEmpty(message = "Jenis Barang Harus Diinputkan")
    private String jenis;
    @NotEmpty(message = "Quantity Barang Harus Diinputkan")
    private String quantity;
    @NotNull(message = "Harga Assets Harus Diinputkan")
    @Min(value = 10, message = "Inputkan Berdasarkan Harga")
    private BigDecimal hargaAssets;
    @NotNull(message = "Tanggal Input Harus Diinputkan")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date tanggalInput;
}
