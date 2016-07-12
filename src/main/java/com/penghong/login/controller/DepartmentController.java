package com.penghong.login.controller;

import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.penghong.login.entities.Department;
import com.penghong.login.service.DepartmentService;

@Controller
@RequestMapping("department")
public class DepartmentController {
	
	@Resource
	private DepartmentService departmentService;
	
	/**
	 * 列表 
	 * @param map
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Map<String, Object> map){
		map.put("listDepartment", departmentService.findAll());
		
		return "department/list";
	}
	/**
	 * 添加页面
	 * @return
	 */
	  @RequestMapping("/addUI")
	  public String addUI(){
		  return "department/addUI";
	  }
	  
	  /**
	   * 添加 
	   * @return
	   */
	  @RequestMapping("/add")
	  public String add(Department department){
		  departmentService.save(department);
		  
		  return "redirect:/department/list";
	  }
	
	

}
