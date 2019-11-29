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

import com.hrms.bean.Employee;
import com.hrms.service.EmployeeService;
import com.hrms.util.EncodingTool;
import com.hrms.util.JsonMsg;

/**
 * @author GenshenWang.nomico
 * @date 2018/3/7.
 */
@Controller
@RequestMapping(value = "/hrms/emp")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	/**
	 * 员工删除操作
	 * 
	 * @param empId
	 * @return
	 */
	@RequestMapping(value = "/deleteEmp/{empId}", method = RequestMethod.DELETE)
	@ResponseBody
	public JsonMsg deleteEmp(@PathVariable("empId") Integer empId) {
		int res = 0;
		System.out.println("empId:" + empId);
		if (empId > 0) {
			res = employeeService.deleteEmpById(empId);
		}
		if (res != 1) {
			return JsonMsg.fail().addInfo("emp_del_error", "员工删除异常");
		}
		return JsonMsg.success();
	}

	/**
	 * 更改员工信息
	 * 
	 * @param empId
	 * @param employee
	 * @return
	 */
	@RequestMapping(value = "/updateEmp/{empId}", method = RequestMethod.PUT)
	@ResponseBody
	public JsonMsg updateEmp(@PathVariable("empId") Integer empId, Employee employee) {
		int res = employeeService.updateEmpById(empId, employee);
		if (res != 1) {
			return JsonMsg.fail().addInfo("emp_update_error", "更改异常");
		}
		return JsonMsg.success();
	}

	/**
	 * 查询输入的员工姓名是否重复
	 * 
	 * @param empName
	 * @return
	 */
	@RequestMapping(value = "/checkEmpExists", method = RequestMethod.GET)
	@ResponseBody
	public JsonMsg checkEmpExists(@RequestParam("empName") String empName) {
		// 用户名正则，4到16位（字母，数字，下划线，减号）
//        String regName = "/^[a-zA-Z0-9_-]{4,16}$/";
//        if(!empName.matches(regName)){
//            return JsonMsg.fail().addInfo("name_reg_error", "输入姓名为2-5位中文或6-16位英文和数字组合");
//        } 
		System.out.println("empName:" + EncodingTool.encodeStr(empName));
		Employee employee = employeeService.getEmpByName(EncodingTool.encodeStr(empName));
		if (employee != null) {
			return JsonMsg.fail().addInfo("name_reg_error", "用户名重复");
		} else {
			return JsonMsg.success();
		}
	}

	/**
	 * 新增记录后，查询最新的页数
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getTotalPages", method = RequestMethod.GET)
	@ResponseBody
	public JsonMsg getTotalPage() {
		int totalItems = employeeService.getEmpCount();
		// 获取总的页数
		int temp = totalItems / 5;
		int totalPages = (totalItems % 5 == 0) ? temp : temp + 1;
		return JsonMsg.success().addInfo("totalPages", totalPages);
	}

	/**
	 * 新增员工
	 * 
	 * @param employee 新增的员工信息
	 * @return
	 */
	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg addEmp(Employee employee) {
		int res = employeeService.addEmp(employee);
		if (res == 1) {
			return JsonMsg.success();
		} else {
			return JsonMsg.fail();
		}
	}

	/**
	 * 根据id查询员工信息
	 * 
	 * @param empId
	 * @return
	 */
	@RequestMapping(value = "/getEmpById/{empId}", method = RequestMethod.GET)
	@ResponseBody
	public JsonMsg getEmpById(@PathVariable("empId") Integer empId) {
		Employee employee = employeeService.getEmpById(empId);
		if (employee != null) {
			return JsonMsg.success().addInfo("employee", employee);
		} else {
			return JsonMsg.fail();
		}

	}

	/**
	 * 查询
	 * 
	 * @param pageNo 查询指定页码包含的数据
	 * @return
	 */
	@RequestMapping(value = "/getEmpList", method = RequestMethod.GET)
	public ModelAndView getEmp(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) {
		ModelAndView mv = new ModelAndView("employeePage");
		int limit = 5;
		// 记录的偏移量(即从第offset行记录开始查询)，
		// 如第1页是从第1行(offset=(21-1)*5=0,offset+1=0+1=1)开始查询；
		// 第2页从第6行(offset=(2-1)*5=5,offset+1=5+1=6)记录开始查询
		int offset = (pageNo - 1) * limit;
		// 获取指定页数包含的员工信息
		List<Employee> employees = employeeService.getEmpList(offset, limit);
		// 获取总的记录数
		int totalItems = employeeService.getEmpCount();
		// 获取总的页数
		int temp = totalItems / limit;
		int totalPages = (totalItems % limit == 0) ? temp : temp + 1;
		// 当前页数
		int curPage = pageNo;

		// 将上述查询结果放到Model中，在JSP页面中可以进行展示
		mv.addObject("employees", employees).addObject("totalItems", totalItems).addObject("totalPages", totalPages)
				.addObject("curPage", curPage);
		return mv;
	}
}
