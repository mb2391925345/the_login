package com.penghong.login.service;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.penghong.login.entities.Department;
import com.penghong.login.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentService {
	@Resource
	private DepartmentRepository departmentRepository;
	
	public Department findDepartmentById(Integer id ){
		if(id==null){
			return null;
		}
		return departmentRepository.findOne(id);
	}

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	public  void save(Department department) {
		departmentRepository.save(department);
		
	}

}
