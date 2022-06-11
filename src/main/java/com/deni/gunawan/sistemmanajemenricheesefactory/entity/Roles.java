package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
public class Roles {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
