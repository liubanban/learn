package com.cn.lab.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.lab.model.AjaxObj;
import com.cn.lab.model.SysMenu;
import com.cn.lab.service.SySMenuService;
import com.cn.lab.util.ModelUtil;
import com.cn.sys.page.PageUtil;
import com.cn.sys.tree.TreeNode;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private SySMenuService sySMenuService;
	
	/**
	 * 跳转到menulist页面
	 * 
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("menuList.do")
	public ModelAndView menuList(HttpServletRequest req, HttpServletResponse rsp,SysMenu query) {
		ModelAndView view = new ModelAndView();
		view.addObject("query",query);
		view.addObject("sySMenuService", sySMenuService);
		view.setViewName("lab/menu/menulist.html");
		return ModelUtil.Init(view);
	}

	/**
	 * 获取用户列表信息
	 * 
	 * @return
	 */
	@RequestMapping("getMenuList.do")
	@ResponseBody
	public PageInfo<SysMenu> getMenuList(HttpServletRequest req, HttpServletResponse rsp,SysMenu query) {
		
		//分页参数,使用插件进行分页
		PageUtil.startPage(req);
		PageUtil.startOrderBy(req);
		
		List<SysMenu> list = sySMenuService.selectAllByQuery(query);
		req.setAttribute("sySMenuService", sySMenuService);
		return PageUtil.getBTPageInfo(list);
	}
	
	/**
	 * 跳转到menuadd页面
	 * 
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("menuInfo.do")
	public ModelAndView menuAdd(HttpServletRequest req, HttpServletResponse rsp,SysMenu menu) {
		ModelAndView view = new ModelAndView();
		if(menu!=null){
			menu = sySMenuService.selectByPrimaryKey(menu.getId());
			view.addObject("menu", menu);
		}
		view.addObject("type", req.getParameter("type"));
		view.setViewName("lab/menu/menuinfo.html");
		return ModelUtil.Init(view);
	}

	/**
	 * 保存menu
	 * 
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("suMenu.do")
	@ResponseBody
	public AjaxObj suMenu(HttpServletRequest req, HttpServletResponse rsp,SysMenu menu) {
		AjaxObj ao = new AjaxObj();
		int i =0;
		if(menu!=null){
			if(menu.getId()!=null){
				i = sySMenuService.updateByPrimaryKeySelective(menu);
			}else{
				i = sySMenuService.insertSelective(menu);
			}
		}
		
		if(i>0){
			ao.setIssuccess(true);
		}else{
			ao.setIssuccess(false);
			ao.setMsg("操作失败,请查看日志!");
		}
		return ao;
	}

	/**
	 * 保存menu
	 * 
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("delMenu.do")
	@ResponseBody
	public AjaxObj delMenu(HttpServletRequest req, HttpServletResponse rsp,SysMenu menu) {
		AjaxObj ao = new AjaxObj();
		int i =0;
		if(menu!=null&&menu.getIds()!=null){
			for (String id : menu.getIds().split(",")) {
				i+=sySMenuService.deleteByPrimaryKey(Integer.valueOf(id));
			}
		}
		if(i>0){
			ao.setIssuccess(true);
		}else{
			ao.setIssuccess(false);
		}
		return ao;
	}

	/**
	 * 获取菜单节点信息
	 * 
	 * @return
	 */
	@RequestMapping("getNodeList.do")
	@ResponseBody
	public List<TreeNode> getNodeList(HttpServletRequest req, HttpServletResponse rsp ) {
		req.setAttribute("sortName", "pid");
		req.setAttribute("sortOrder", "asc");
		PageUtil.startOrderBy(req);
		List<SysMenu> mlist = sySMenuService.selectAllByQuery(new SysMenu());
		
		TreeNode rootnode = sySMenuService.reListMenus(mlist);
		
		return rootnode.getNodes();
	}
	
}
