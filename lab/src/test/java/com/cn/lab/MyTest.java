package com.cn.lab;

import java.util.Map;

import org.junit.Test;

import com.cn.lab.model.SysMenu;
import com.cn.lab.service.CommonService;
import com.cn.lab.service.SySMenuService;
import com.cn.lab.util.VelocityUtil;

/**
 * 继承beanholder 获得spring容器
 * @author liubanban
 *
 */
public class MyTest extends BeanHolder{


	@Test
	public void VelocityUtilgetVByK(){
		String result = VelocityUtil.getVByK("sysmenu", "id", "5", "menuname");
		System.out.println(result);
	}
	
	/**
	 * 测试动态生成sql获取值
	 */
	@Test
	public void getVByK(){
		CommonService commonService = (CommonService) ac.getBean("commonService");
		Map<String, Object> vmap = commonService.getVByK("sysmenu", "id", "5", "menuname");
		System.out.println("===========================");
		System.out.println(vmap);
	}
	
	 
}
