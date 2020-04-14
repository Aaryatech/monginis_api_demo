package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class GetUserDetail {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="usr_id")
	private Long id;
    @Column(name="usr_name",unique=true)
	private String username;
    @Column(name="usr_pwd")
    private String password;
	@Column(name="usr_type")
    private int usertype;
	@Column(name="del_status")
    private int delStatus;
	@Column(name="email")
    private String email;
	@Column(name="contact")
    private String contact;
	
	@Column(name="dept_id")
    private int deptId;
	
	@Column(name="role_id")
    private int roleId;
	
	@Column(name="dept_name")
    private String deptName;
	
	
	@Column(name="role_name")
    private String roleName;
	
	
	@Column(name="type_name")
    private String typeName;



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getUsertype() {
		return usertype;
	}


	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}


	public int getDelStatus() {
		return delStatus;
	}


	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}


	public int getDeptId() {
		return deptId;
	}


	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	@Override
	public String toString() {
		return "GetUserDetail [id=" + id + ", username=" + username + ", password=" + password + ", usertype="
				+ usertype + ", delStatus=" + delStatus + ", email=" + email + ", contact=" + contact + ", deptId="
				+ deptId + ", roleId=" + roleId + ", deptName=" + deptName + ", roleName=" + roleName + ", typeName="
				+ typeName + "]";
	}



}
