package com.hrms.bean;

import java.util.Date;
/**
 * @Title Task.java
 * @description TODO
 * @time 2019年11月23日 下午5:05:09
 * @author ganluhua
 * @version 1.0
 */
public class Task {
	private Integer taskId;
	private String taskName;
	private Integer empId;
	private Date createtime;
	private Date updatetime;
	private Integer status;
	private String remarks;
	
	private Employee employee;
	
	public Integer getTaskId() {
		return this.taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return this.taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Integer getEmpId() {
		return this.empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Date getCreatetime() {
		return this.createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return this.updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemarks() {
		return this.remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public Employee getEmployee() {
		return this.employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/* 为啥一定要写这句话 不写会报错  */
	public Task() {
    }
	/* 构造函数 */
	public Task( Integer taskId, String taskName, Integer empId, Date createtime,
				 Date updatetime, Integer status, String remarks) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.empId = empId;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.status = status;
		this.remarks = remarks;
	}
	
	@Override
	public String toString() {
		return "Task{" + 
					"taskId=" + taskId +
					", taskName=' " + taskName + '\'' +
					", empId=' " + empId + '\'' +
					", createtime=' " + createtime + '\'' +
					", updatetime=' " + updatetime + '\'' +
					", status=' " + status + '\'' +
					", remarks=' " + remarks + '\'' +
				"}";
	}
}
