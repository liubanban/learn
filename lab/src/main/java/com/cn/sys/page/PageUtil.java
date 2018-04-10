package com.cn.sys.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class PageUtil  {

	/**
	 * 获取用于bootstraptable的分页对象,里面包含一个rows
	 * @param <T>
	 * @param list
	 * @return
	 */
	public static <T> PageInfo<T> getBTPageInfo(List<T>  list) {
		return new BTPageInfo<T> (list);
	}

	/**
	 * 开启分页插件分页功能
	 * 
	 * @param req
	 */
	public static void startPage(HttpServletRequest req) {
		int pageNum = req.getParameter("pageNum") == null ? 1 : Integer.valueOf(req.getParameter("pageNum"));
		int pageSize = req.getParameter("pageSize") == null ? 10 : Integer.valueOf(req.getParameter("pageSize"));

		// 使用分页插件进行分页
		PageHelper.startPage(pageNum, pageSize);
	}


	/**
	 * 开启分页插件自动排序功能,一般上是结合bootstraptable页面上的列排序
	 * 
	 * @param req
	 */
	public static void startOrderBy(HttpServletRequest req) {
		String orderBy = "";
		String sortName = (String) (req.getParameter("sortName")==null?req.getAttribute("sortName"):req.getParameter("sortName"));
		String sortOrder =  (String) (req.getParameter("sortOrder")==null?req.getAttribute("sortOrder"):req.getParameter("sortOrder"));
		if(StringUtils.isNotBlank(sortName)&&StringUtils.isNotBlank(sortOrder)){
			orderBy = sortName + " "+ sortOrder;
			// 使用分页插件进行排序
			PageHelper.orderBy(orderBy);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.valueOf(null));
	}
}
