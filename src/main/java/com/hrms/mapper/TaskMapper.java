package com.hrms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hrms.bean.Task;

/**
 * @author ganluhua
 * @date 2019/11/20
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public interface TaskMapper {
	String TABLE_NAME = "tbl_task";
	String INSERT_FIELDS = "task_name, emp_id, createtime, updatetime, status, remarks";
	String SELECT_FIELDS = "task_id," + INSERT_FIELDS;
	
	/* 删除 */
	@Delete({"DELETE FROM", TABLE_NAME, "WHERE task_id = #{taskId}"})
	int deleteOneById(@Param("taskId") Integer taskId);
	
	/* 修改 */
	int updateOneById(@Param("taskId") Integer taskId,
					  @Param("employee") Task task);
	/* 新增 */
	@Insert({ 
		"INSERT INTO", TABLE_NAME, "(", INSERT_FIELDS, ")" + 
		"VALUES(#{taskName}, " + 
		"#{empId}, " + 
		"#{createtime}, " + 
		"#{updatetime}, " + 
		"#{status}, " + 
		"#{remarks}) "
	})
	int insertTask(Task task);
	
	//	查询  单个查询  分页查询
//	@Select({"SELECT", SELECT_FIELDS, "FROM", TABLE_NAME, "WHERE task_id=#{taskId}"})
	Task selectTaskById(Integer taskId);
//	@Select({"SELECT", SELECT_FIELDS, "FROM", TABLE_NAME, "WHERE task_name=#{taskName}"})
	Task selectTaskByName(@Param("taskId") String taskName);
	
	@Select({"SELECT", SELECT_FIELDS, "FROM", TABLE_NAME})
	List<Task> selectTaskList();
	
	List<Task> selectTaskByLimitAndOffset(@Param("offset") Integer offset,
										  @Param("limit") Integer limit);
	
	//	查询总条数
	@Select({"SELECT COUNT(*) FROM", TABLE_NAME})
	int countTasks();
}
