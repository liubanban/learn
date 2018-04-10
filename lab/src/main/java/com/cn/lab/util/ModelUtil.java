package com.cn.lab.util;

import org.springframework.web.servlet.ModelAndView;
 
public class ModelUtil {

	/**
	 * 处理view  将控制层设置的替换成固定的首页,并换成属性值
	 * @param view
	 * @return
	 */
	public static ModelAndView Init(ModelAndView view) {
		view.addObject("basepath", ContextHolderUtils.getRequest().getContextPath());
		return view; 
	}
}
