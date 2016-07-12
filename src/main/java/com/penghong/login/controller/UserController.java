package com.penghong.login.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.penghong.login.entities.Department;
import com.penghong.login.entities.Role;
import com.penghong.login.entities.User;
import com.penghong.login.service.DepartmentService;
import com.penghong.login.service.RoleService;
import com.penghong.login.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	@Resource
	private DepartmentService departmentService;

	/**
	 * 登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/loginUI")
	public String loginUI() {
		return "user/login";

	}

	/**
	 * 登录
	 * 
	 * @param user
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(User user, HttpSession session, Map<String, Object> map) {
		//包含登录信息的Map
		Map<String,Object> login = userService.loginCheck(user.getLoginName(), user.getPassword());
		if ((boolean)login.get("check")) {
			session.setAttribute("user", (User)login.get("user"));
			return "redirect:/user/list";
		}
		map.put("loginError", "用户名或密码错误");
		map.put("loginName", user.getLoginName());
		return "user/login";
	}

	/**
	 * 注册页面
	 * 
	 * @return
	 */
	@RequestMapping("/registerUI")
	public String registerUI(Map<String, Object> map) {
		map.put("departments", departmentService.findAll());
		map.put("roles", roleService.findAll());
		return "user/register";
	}

	/**
	 * 注册
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("register")
	public String register(User user, Integer[] roles, Integer department) {
		
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		List<Role> roles2 = roleService.findByIds(roles);

		Department department2 = departmentService.findDepartmentById(department);
		user.setDepartment(department2);
		user.setRoles(roles2);

		userService.save(user);
		return "user/login";
	}

	/**
	 * 用户信息列表
	 * 
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping("/list")
	public String listUsers(Map<String, Object> map, @RequestParam(required = false, defaultValue = "0") Integer pageNo,
			HttpSession session) {
		Page<User> listUser = userService.pageList(pageNo);
		map.put("page", listUser);
		map.put("user", session.getAttribute("user"));
		return "user/index";
	}

	/**
	 * 修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/updateUI")
	public String updateUserUI(Integer id, Map<String, Object> map) {
		map.put("user", userService.findById(id));
		map.put("departments", departmentService.findAll());
		map.put("roles", roleService.findAll());
		return "user/updateUI";
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	@RequestMapping("/update")
	public String updateUser(User user, Integer[] roles, Integer department) {
		List<Role> roles2 = roleService.findByIds(roles);
		Department department2 = departmentService.findDepartmentById(department);
		user.setDepartment(department2);
		user.setRoles(roles2);
		userService.save(user);
		return "redirect:/user/list";
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public String deleteUser(Integer id) {
		userService.delete(id);
		return "redirect:/user/list";
	}

	/**
	 * 测试bootstrap
	 * 
	 * @return
	 */
	@RequestMapping("/test")
	public String testBootstrap() {
		return "test/NewFile1";
	}

}
