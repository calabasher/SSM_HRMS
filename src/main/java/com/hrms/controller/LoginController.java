package com.hrms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrms.bean.User;
import com.hrms.service.UserService;
import com.hrms.util.JsonMsg;

/**
 * @author GenshenWang.nomico
 * @date 2018/3/9.
 */
@Controller
@RequestMapping(value = "/hrms")
public class LoginController {
	
	@Autowired
	UserService userService;
    /**
     * 登录：跳转到登录页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 对登录页面输入的用户名和密码做简单的判断
     * @param request
     * @return
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg dologin(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.getUserInfoByUserName(username);
        if(user == null) {
        	return JsonMsg.fail().addInfo("login_error","用户不存在");
        }
        System.out.println("getPassword:"+user.getPassword());
        if(!user.getPassword().equals(password)) {
        	return JsonMsg.fail().addInfo("login_error","密码不正确");
        }
        return JsonMsg.success();
    }

    /**
     * 跳转到主页面
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(){
        return "main";
    }

    /**
     * 退出登录：从主页面跳转到登录页面
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        return "login";
    }
}
