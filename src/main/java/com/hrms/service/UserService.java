package com.hrms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.bean.User;
import com.hrms.mapper.UserMapper;
@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	// 根据用户名获取用户信息
	public User getUserInfoByUserName(String userName) {
		return userMapper.getUserInfoByUserName(userName);
	}
}
