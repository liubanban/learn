package com.cn.lab.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.lab.model.SysMenu;
import com.cn.lab.service.SySMenuService;
import com.cn.lab.util.ContextHolderUtils;
import com.cn.lab.util.ModelUtil;
import com.cn.sys.page.PageUtil;
import com.cn.sys.tree.TreeNode;

@Controller
@RequestMapping("demo")
public class DemoController {

	@Autowired
	private SySMenuService sySMenuService ;
	
	@RequestMapping("toForm")
	public ModelAndView toForm(){
		ModelAndView view = new ModelAndView();
		view.setViewName("lab/demo/form.html");
		
		return ModelUtil.Init(view);
	}
	
	/**
	 * 获取菜单节点信息
	 * 
	 * @return
	 */
	@RequestMapping("getNodeList.do")
	@ResponseBody
	public List<TreeNode> getNodeList(HttpServletRequest req, HttpServletResponse rsp ) {
		PageUtil.startOrderBy(req);
		List<SysMenu> mlist = sySMenuService.selectAllByQuery(new SysMenu());
		
		TreeNode rootnode = sySMenuService.reListMenus(mlist);
		
		return rootnode.getNodes();
	}
	
}
