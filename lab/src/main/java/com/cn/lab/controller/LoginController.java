
package com.cn.lab.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.lab.model.SysMenu;
import com.cn.lab.service.SySMenuService;
import com.cn.lab.service.UserTService;
import com.cn.lab.util.ModelUtil;
import com.cn.sys.page.PageUtil;
import com.cn.sys.tree.TreeNode;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private SySMenuService sySMenuService;
	@Autowired
	private UserTService userTService;
	/**
	 * @param req
	 * @param rps
	 * @return
	 */
	@RequestMapping("doLogin.do")
	public ModelAndView doLogin(HttpServletRequest req,HttpServletResponse rps) {
		ModelAndView view = new ModelAndView();
		view.setViewName("lab/main.html");
		req.setAttribute("sortName", "pid");
		req.setAttribute("sortOrder", "asc");
		PageUtil.startOrderBy(req);
		List<SysMenu> mlist = sySMenuService.selectAllByQuery(new SysMenu());
		TreeNode rootnode = sySMenuService.reListMenus(mlist);
		view.addObject("nodes", rootnode.getNodes());
		return ModelUtil.Init(view);
	}

	/**
	 * @param req
	 * @param rps
	 * @return
	 */
	@RequestMapping("toWelcome.do")
	public ModelAndView toWelcome(HttpServletRequest req,HttpServletResponse rps) {
		ModelAndView view = new ModelAndView();
		view.setViewName("lab/welcome.html");
		view.addObject("userTService", userTService);
		return ModelUtil.Init(view);
	}

	/**
	 * @param req
	 * @param rps
	 * @return
	 */
	@RequestMapping("doTest.do")
	public ModelAndView doTest(HttpServletRequest req,HttpServletResponse rps) {
		ModelAndView view = new ModelAndView();
		view.setViewName("lab/test.html");
		return ModelUtil.Init(view);
	}
}
