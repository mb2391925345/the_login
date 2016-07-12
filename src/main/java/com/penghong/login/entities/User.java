package com.penghong.login.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





@Entity
@Table(name="user_")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="login_name")
	private String loginName;
	@Column(name="name_")
	private String name;
	@Column(name="password_")
	private String password;
	
	@JoinColumn(name="department_id")
    @ManyToOne(fetch=FetchType.EAGER)
	private Department department;
	
	@JoinTable(name="user_role",
			joinColumns={@JoinColumn(name="user_id",referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="role_id",referencedColumnName="id")})
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Role> roles =new ArrayList<>();

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
    
	
	public List<Role> getRoles() {
		return roles;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", name=" + name + ", password=" + password + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public User(String loginName, String name, String password) {
		super();
		this.loginName = loginName;
		this.name = name;
		this.password = password;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passWord) {
		this.password = passWord;
	}
	public User(){
		
	}

}
