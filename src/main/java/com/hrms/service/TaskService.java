package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.bean.Task;
import com.hrms.mapper.TaskMapper;

/**
 * @author ganluhua
 * @date 2019/11/23
 * @desc 工作任务服务层
 */
@Service
public class TaskService {
	@Autowired
	TaskMapper taskMapper;
	
	public int deleteTaskById(Integer taskId) {
		return taskMapper.deleteOneById(taskId);
	}
	public int updateTaskById(Integer taskId, Task task) {
		return taskMapper.updateOneById(taskId, task);
	}
	public int addTask(Task task) {
		return taskMapper.insertTask(task);
	}
	public int getTaskCount() {
		return taskMapper.countTasks();
	}
	public List<Task> getTaskList(Integer offset, Integer limit){
		return taskMapper.selectTaskByLimitAndOffset(offset, limit);
	}
	public Task getTaskById(Integer taskId){
		return taskMapper.selectTaskById(taskId);
	}
	public Task getTaskByTaskName(String taskName) {
		return taskMapper.selectTaskByName(taskName);
	}
	
	public List<Task> getTaskName(){
		return taskMapper.selectTaskList();
	}
}
