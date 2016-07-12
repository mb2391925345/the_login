package com.penghong.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.penghong.login.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	

}
