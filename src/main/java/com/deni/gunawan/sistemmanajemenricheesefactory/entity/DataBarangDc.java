package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "barang_dc")
public class DataBarangDc {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;
    private String staffPengirim;
    private String nameProduct;
    @ManyToOne
    @JoinColumn(name = "type_assets", nullable = false)
    private DataTypeAssets typeAssets;
}
