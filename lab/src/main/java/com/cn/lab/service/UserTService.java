package com.cn.lab.service;

import java.util.List;

import com.cn.lab.model.UserT;

public interface UserTService {

	UserT selectByPrimaryKey(int id);
	
	List<String> add(String a ,String b );
}
