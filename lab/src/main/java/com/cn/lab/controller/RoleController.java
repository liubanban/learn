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
import com.cn.lab.model.SysRole;
import com.cn.lab.service.SySRoleService;
import com.cn.lab.util.ModelUtil;
import com.cn.sys.page.PageUtil;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("role")
public class RoleController {

	@Autowired
	private SySRoleService sySRoleService;

	/**
	 * 跳转到rolelist页面
	 * 
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("roleList.do")
	public ModelAndView roleList(HttpServletRequest req, HttpServletResponse rsp, SysRole query) {
		ModelAndView view = new ModelAndView();
		view.addObject("query", query);
		view.setViewName("lab/role/rolelist.html");
		return ModelUtil.Init(view);
	}

	/**
	 * 获取用户列表信息
	 * 
	 * @return
	 */
	@RequestMapping("getRoleList.do")
	@ResponseBody
	public PageInfo<SysRole> getRoleList(HttpServletRequest req, HttpServletResponse rsp, SysRole query) {

		// 分页参数,使用插件进行分页
		PageUtil.startPage(req);
		PageUtil.startOrderBy(req);

		List<SysRole> list = sySRoleService.selectAllByQuery(query);

		return PageUtil.getBTPageInfo(list);
	}

	/**
	 * 跳转到roleadd页面
	 * 
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("roleInfo.do")
	public ModelAndView roleAdd(HttpServletRequest req, HttpServletResponse rsp, SysRole role) {
		ModelAndView view = new ModelAndView();
		if (role != null) {
			role = sySRoleService.selectByPrimaryKey(role.getId());
			view.addObject("role", role);
		}
		view.addObject("type", req.getParameter("type"));
		view.setViewName("lab/role/roleinfo.html");
		return ModelUtil.Init(view);
	}

	/**
	 * 保存role
	 * 
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("suRole.do")
	@ResponseBody
	public AjaxObj suRole(HttpServletRequest req, HttpServletResponse rsp, SysRole role) {
		AjaxObj ao = new AjaxObj();
		int i = 0;
		if (role != null) {
			if (role.getId() != null) {
				i = sySRoleService.updateByPrimaryKeySelective(role);
			} else {
				i = sySRoleService.insertSelective(role);
			}
		}

		if (i > 0) {
			ao.setIssuccess(true);
		} else {
			ao.setIssuccess(false);
			ao.setMsg("操作失败,请查看日志!");
		}
		return ao;
	}

	/**
	 * 保存role
	 * 
	 * @param req
	 * @param rsp
	 * @return
	 */
	@RequestMapping("delRole.do")
	@ResponseBody
	public AjaxObj delRole(HttpServletRequest req, HttpServletResponse rsp, SysRole role) {
		AjaxObj ao = new AjaxObj();
		int i = 0;
		if (role != null && role.getIds() != null) {
			for (String id : role.getIds().split(",")) {
				i += sySRoleService.deleteByPrimaryKey(Integer.valueOf(id));
			}
		}
		if (i > 0) {
			ao.setIssuccess(true);
		} else {
			ao.setIssuccess(false);
		}
		return ao;
	}

}
