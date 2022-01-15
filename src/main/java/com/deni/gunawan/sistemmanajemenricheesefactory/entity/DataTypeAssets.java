package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "type_assets")
public class DataTypeAssets {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, unique = true)
    private String id;
    @Column(name = "nama", length = 20)
    private String nama;
    @CreationTimestamp
    @Column(name = "created_date")
    private Timestamp createdDate;
    @UpdateTimestamp
    @Column(name = "update_date")
    private Timestamp updateDate;

}
