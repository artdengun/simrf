package com.deni.gunawan.sistemmanajemenricheesefactory.repository;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository<UserRoles, String> {
}
