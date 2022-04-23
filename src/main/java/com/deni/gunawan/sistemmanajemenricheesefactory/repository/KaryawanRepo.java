package com.deni.gunawan.sistemmanajemenricheesefactory.repository;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author denigunawan
 */

public interface KaryawanRepo extends JpaRepository<Users, String> {
}
