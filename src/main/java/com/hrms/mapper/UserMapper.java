package com.hrms.mapper;

import org.apache.ibatis.annotations.Param;

import com.hrms.bean.User;

public interface UserMapper {
	// 查询用户账号密码
	User getUserInfoByUserName(@Param("userName") String userName);
}
