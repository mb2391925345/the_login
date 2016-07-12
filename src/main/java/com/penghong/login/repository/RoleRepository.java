package com.penghong.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.penghong.login.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	

}
