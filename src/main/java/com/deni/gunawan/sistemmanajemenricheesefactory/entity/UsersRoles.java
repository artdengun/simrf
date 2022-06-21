package com.deni.gunawan.sistemmanajemenricheesefactory.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "users_roles")
public class UsersRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User users;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

}
