package com.catchmind.catchtable.repository;

import com.catchmind.catchtable.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
