package com.deni.gunawan.sistemmanajemenricheesefactory.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "s_user_roles")
public class UserRoles {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

}
