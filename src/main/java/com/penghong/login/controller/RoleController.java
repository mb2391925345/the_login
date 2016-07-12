package com.penghong.login.controller;

import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.penghong.login.entities.Role;
import com.penghong.login.service.RoleService;

@Controller
@RequestMapping("role")
public class RoleController {
	@Resource
	private RoleService roleService;
	
	/**
	 *  职位列表
	 * @param map
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Map<String, Object> map){
		map.put("listRole", roleService.findAll());
		return "role/list";
	}
	/**
	 * 添加页面 
	 */
	@RequestMapping("/addUI")
	public String addUI(){
		return "role/addUI";
	}
	 /**
	  * 添加 
	  */
	@RequestMapping("/add")
	public String add(Role role){
		roleService.save(role);
		return "redirect:/role/list";
	}

}
