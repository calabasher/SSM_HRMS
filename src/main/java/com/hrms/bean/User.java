package com.hrms.bean;

import java.sql.Date;
/**
 * @Title User.java
 * @description 实体类
 * @time 2019年11月29日 上午9:30:54
 * @author ganluhua
 * @version 1.0
 */
//java.util.Date + TIMESTAMP + dateTime
//java.sql.Date + DATE +date
public class User {
	private Integer userId;
	private String userName;
	private String password;
	private Date createTime;
	private Integer role;	// '0: 超级管理员 1：管理员',
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	//	无参构造方法
	public User() {}
	// 有参构造方法
	public User(Integer userId, String userName,String password, Date createTime, Integer role) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.createTime = createTime;
		this.role = role;	// '0: 超级管理员 1：管理员',
	}
	
}
