package com.cn.lab.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.lab.dao.UserTMapper;
import com.cn.lab.model.UserT;
import com.cn.lab.service.UserTService;

@Service("userTService")
public class UserTServiceImpl implements UserTService {

	@Autowired
	private UserTMapper userTMapper;
	
	@Override
	public UserT selectByPrimaryKey(int id) {
		return userTMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<String>  add(String a, String b) {
		System.out.println(a+b);
		List<String> list = new ArrayList<String>();
		list.add(a);
		list.add(b);
		return list;
	}

}
