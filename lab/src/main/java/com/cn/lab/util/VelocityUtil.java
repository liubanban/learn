package com.cn.lab.util;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.cn.lab.service.CommonService;

public class VelocityUtil {
 
	public static String getVByK(String tname, String bykeyname, String bykeyvalue, String keyout) {
		if(StringUtils.isBlank(tname)||StringUtils.isBlank(bykeyname)||StringUtils.isBlank(bykeyvalue)||StringUtils.isBlank(keyout)){
			return "";
		}
		CommonService commonService = (CommonService) ContextHolderUtils.getBean("commonService");
		Map<String, Object> vByK = commonService.getVByK(tname, bykeyname, bykeyvalue, keyout);
		if (vByK != null) {
			return vByK.get(keyout) + "";
		}
		return "";
	}

}
