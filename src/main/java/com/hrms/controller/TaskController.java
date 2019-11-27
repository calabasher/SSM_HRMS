package com.hrms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.bean.Task;
import com.hrms.service.TaskService;
import com.hrms.util.JsonMsg;
/**
 * @author ganluhua
 * @date 2019/11/19
 * @desc 工作任务控制器
 */
@Controller
@RequestMapping(value = "/hrms/task")
public class TaskController {
	@Autowired
	TaskService taskService;
	
	/**
	 * 删除任务
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/deleteTask/{taskId}", method = RequestMethod.DELETE)
	@ResponseBody
	public JsonMsg deleteTask(@PathVariable("taskId") Integer taskId) {
		int res = 0;
		if(taskId > 0) {
			res = taskService.deleteTaskById(taskId);
		}
		if(res != 1) {
			return JsonMsg.fail().addInfo("del_task_error", "删除异常");
		}
		return JsonMsg.success();
	}
	
	/**
	 * 任务更改
	 */
	@RequestMapping(value = "/updateTask/{taskId}", method = RequestMethod.PUT)
	@ResponseBody
	public JsonMsg updateTaskById(@PathVariable("taskId") Integer taskId, Task task) {
		int res = 0;
		if(taskId > 0) {
			res = taskService.updateTaskById(taskId, task);
		}
		if(res != 1) {
			return JsonMsg.fail().addInfo("update_task_error", "任务更新失败");
		}
		return JsonMsg.success();
	}
	/**
	 * 新增任务
	 */
	@RequestMapping(value = "/addTask", method = RequestMethod.PUT)
	@ResponseBody
	public JsonMsg addTask(Task task) {
		int res = taskService.addTask(task);
		if(res != 1) {
			return JsonMsg.fail().addInfo("add_dept_erro", "添加异常！");
		}
		return JsonMsg.success();
	}
	/**
	 *  查询任务信息总码数
	 *  @return
	 */
	@RequestMapping(value = "/getTotalPages", method = RequestMethod.GET)
	@ResponseBody
	public JsonMsg getTotalPages() {
		// 每页显示的记录行数
		int limit = 5;
		// 总记录数
		int totalItems = taskService.getTaskCount();
		int temp = totalItems / limit;
		int totalPages = (totalItems % limit == 0) ? temp : temp - 1;
		return JsonMsg.success().addInfo("totalPages", totalPages);
	}
	/**
	 * 根据任务id获取任务
	 */
	@RequestMapping(value = "/getTaskById/{taskId}", method = RequestMethod.GET)
	@ResponseBody
	public JsonMsg getTaskById(@PathVariable("taskId") Integer taskId) {
		Task task = null;
		if(taskId > 0) {
			task = taskService.getTaskById(taskId);
		}
		if(task != null) {
			return JsonMsg.success().addInfo("task", task);
		}
		return JsonMsg.fail().addInfo("get_task_error", "无任务信息");
	}
	/**
	 * 分页查询，返回指定页数对应的数据
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value = "/getTaskList", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getTaskList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) {
		ModelAndView mv = new ModelAndView("taskPage");
		// 每页显示的记录行数
		int limit = 5;
		// 总记录数
		int totalItems = taskService.getTaskCount();
		int temp = totalItems / limit;
		int totalPages = (totalItems % limit == 0) ? temp : temp + 1;
		int offset = (pageNo - 1) * limit;
		List<Task> tasks = taskService.getTaskList(offset, limit);
		
		mv.addObject("tasks", tasks)
			.addObject("totalItems", totalItems)
			.addObject("totalPages", totalPages)
			.addObject("curPageNo", pageNo);
		return mv;
	}
	/**
	 * 查询任务名称
	 */
	@RequestMapping(value = "getTaskName", method = RequestMethod.GET)
	@ResponseBody
	public JsonMsg getTaskName() {
		List<Task> taskList = taskService.getTaskName();
		if(taskList != null) {
			return JsonMsg.success().addInfo("taskList", taskList);
		}
		return JsonMsg.fail();
	}
}
