package com.spring.boot.development.sa.repository;


import com.spring.boot.development.sa.models.ERole;
import com.spring.boot.development.sa.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
	Optional<Role> findByName(ERole name);
}
