package com.cn.lab.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.lab.model.AjaxObj;
import com.cn.lab.service.CommonService;

@Controller
@RequestMapping("common")
public class CommonController {

	@Autowired
	private CommonService commonService ;
	/**
	 * 根据参数去后台获取对应key的值 一般上用来 id换name
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("getVByK")
	@ResponseBody
	public AjaxObj getVByK(HttpServletRequest req,HttpServletResponse rsp){
		AjaxObj ao = new AjaxObj();
		
		String tname = req.getParameter("tname");
		String bykeyname = req.getParameter("bykeyname");
		String bykeyvalue = req.getParameter("bykeyvalue");
		String keyout = req.getParameter("keyout");

		if(StringUtils.isBlank(tname)||StringUtils.isBlank(bykeyname)||StringUtils.isBlank(bykeyvalue)||StringUtils.isBlank(keyout)){
			ao.setIssuccess(false);
		}else{
			Map<String, Object> vByK = commonService.getVByK(tname, bykeyname, bykeyvalue, keyout);
			if(vByK!=null){
				ao.setIssuccess(true);
				ao.setData(vByK.get(keyout));
			}else{
				ao.setIssuccess(false);
			}
		}
		return ao;
	}
	
	
}
