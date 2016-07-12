package com.penghong.login.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.penghong.login.entities.Role;
import com.penghong.login.repository.RoleRepository;

@Service
@Transactional
public class RoleService {
	@Resource
	private RoleRepository roleRepository;
	
	public List<Role> findByIds(Integer[] roles){
		if(roles==null){
			return new ArrayList<>();
			
		}
		return roleRepository.findAll(Arrays.asList(roles));
	    
		
	}

	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	public Role save(Role role) {
		return roleRepository.save(role);
	
		
	}

}
