package com.cn.lab.service;

import java.util.Map;

public interface CommonService {
	
	Map<String, Object> getVByK(String tname, String bykeyname, String bykeyvalue, String keyout);
}
