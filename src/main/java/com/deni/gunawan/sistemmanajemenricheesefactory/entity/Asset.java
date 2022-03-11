package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @Column(name = "no_assets", length = 50)
    private String noAssets;
    private String vendor;
    private String pic;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date tanggalDiterima;
    private String nama;
    private String jenis;
    private String quantity;
    private BigDecimal hargaAssets;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date tanggalInput;
}
