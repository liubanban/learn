package com.cn.lab.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.lab.dao.SysMenuMapper;
import com.cn.lab.model.SysMenu;
import com.cn.lab.service.SySMenuService;
import com.cn.sys.tree.TreeNode;

@Service("sySMenuService")
public class SySMenuServiceImpl implements SySMenuService {

	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sysMenuMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysMenu record) {
		return sysMenuMapper.insert(record);
	}

	@Override
	public int insertSelective(SysMenu record) {
		return sysMenuMapper.insertSelective(record);
	}

	@Override
	public SysMenu selectByPrimaryKey(Integer id) {
		return sysMenuMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SysMenu record) {
		return sysMenuMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysMenu record) {
		return sysMenuMapper.updateByPrimaryKey(record);
	}

	/**
	 * 根据查询条件,查询
	 */
	@Override
	public List<SysMenu> selectAllByQuery(SysMenu query) {
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isNotBlank(query.getMenucode())) {
			map.put("menucode", query.getMenucode());
		}
		if (StringUtils.isNotBlank(query.getMenuname())) {
			map.put("menuname", query.getMenuname());
		}
		return sysMenuMapper.selectAllByQuery(query);
	}

	/**
	 * 根据查询的菜单列表,重新组织菜单树结构
	 */
	@Override
	public TreeNode reListMenus(List<SysMenu> mlist) {
		TreeNode rootNode = new TreeNode();
		List<TreeNode> list = transform(mlist);
		//菜单list已经按照pid排序了,因此可以根据pid首先进行分组组装多个nodelist,然后再将组装好的nodelist挂到对应的
		Integer oldpid = list.get(0).getPid();//记录旧pid
		List<TreeNode> tmpList = new ArrayList<TreeNode>();//先初始化一个list
		int size = list.size();
		for (int i = 0; i < size; i++) {
			TreeNode node = list.get(i);
			Integer newpid = node.getPid();//判断这个和上一个是否一样,因为已经排序了,所以不一样的话,可以认为这个组里没有了可以开始下一组
			if(oldpid == newpid){//如果相同,那么继续添加
				tmpList.add(node);
			}else{//如果不同,那么需要先把之前的list挂到应该挂的node上,特殊判断下,如果是最高级的话,挂到rootnode上
				hangOn(list,tmpList,rootNode,oldpid);
				tmpList = new ArrayList<TreeNode>();//重置list对象
				tmpList.add(node);
			}
			oldpid = node.getPid();
			if(i==(size-1)){
				//这里如果是最后一个的话,不用判断,直接将tmplist挂到对应位置就行
				hangOn(list,tmpList,rootNode,oldpid);
			}
		}
		return rootNode;
	}

	/**
	 * 将tmplist挂到对应的node上,如果么有那么挂到rootnode上
	 * @param list
	 * @param tmpList
	 * @param rootNode
	 * @param oldpid
	 */
	private void hangOn(List<TreeNode> list,List<TreeNode> tmpList,TreeNode rootNode,int oldpid){
		boolean flag = false;
		for (TreeNode pnode : list) {
			if(pnode.getId()==oldpid){
				pnode.setNodes(tmpList);
				flag = true;
			}
		}
		if(!flag){
			rootNode.setNodes(tmpList);
		}
	}
	
	/**
	 * 将menulist 转换成 nodelist
	 * @param mlist
	 * @return
	 */
	private List<TreeNode> transform(List<SysMenu> mlist){
		List<TreeNode> list = new ArrayList<TreeNode>();
		for (SysMenu menu : mlist) {
			TreeNode node = new TreeNode();
			node.setId(menu.getId());
			node.setPid(menu.getPid());
			node.setText(menu.getMenuname());
			node.setHref(menu.getMenuurl());
			list.add(node);
		}
		return list;
	}
	
}
