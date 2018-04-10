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
import com.cn.lab.model.SysUser;
import com.cn.lab.service.SySUserService;
import com.cn.lab.util.ModelUtil;
import com.cn.sys.page.PageUtil;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private SySUserService sySUserService;
	
	/**
	 * 跳转到userlist页面
	 * 
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("userList.do")
	public ModelAndView userList(HttpServletRequest req, HttpServletResponse rsp,SysUser query) {
		ModelAndView view = new ModelAndView();
		view.addObject("query",query);
		view.setViewName("lab/user/userlist.html");
		return ModelUtil.Init(view);
	}

	/**
	 * 获取用户列表信息
	 * 
	 * @return
	 */
	@RequestMapping("getUserList.do")
	@ResponseBody
	public PageInfo<SysUser> getUserList(HttpServletRequest req, HttpServletResponse rsp,SysUser query) {
		
		//分页参数,使用插件进行分页
		PageUtil.startPage(req);
		PageUtil.startOrderBy(req);
		
		List<SysUser> list = sySUserService.selectAllByQuery(query);
		
		return PageUtil.getBTPageInfo(list);
	}
	
	/**
	 * 跳转到useradd页面
	 * 
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("userInfo.do")
	public ModelAndView userAdd(HttpServletRequest req, HttpServletResponse rsp,SysUser user) {
		ModelAndView view = new ModelAndView();
		if(user!=null){
			user = sySUserService.selectByPrimaryKey(user.getId());
			view.addObject("user", user);
		}
		view.addObject("type", req.getParameter("type"));
		view.setViewName("lab/user/userinfo.html");
		return ModelUtil.Init(view);
	}

	/**
	 * 保存user
	 * 
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("suUser.do")
	@ResponseBody
	public AjaxObj suUser(HttpServletRequest req, HttpServletResponse rsp,SysUser user) {
		AjaxObj ao = new AjaxObj();
		int i =0;
		if(user!=null){
			if(user.getId()!=null){
				i = sySUserService.updateByPrimaryKeySelective(user);
			}else{
				i = sySUserService.insertSelective(user);
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
	 * 保存user
	 * 
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("delUser.do")
	@ResponseBody
	public AjaxObj delUser(HttpServletRequest req, HttpServletResponse rsp,SysUser user) {
		AjaxObj ao = new AjaxObj();
		int i =0;
		if(user!=null&&user.getIds()!=null){
			for (String id : user.getIds().split(",")) {
				i+=sySUserService.deleteByPrimaryKey(Integer.valueOf(id));
			}
		}
		if(i>0){
			ao.setIssuccess(true);
		}else{
			ao.setIssuccess(false);
		}
		return ao;
	}
	
}
