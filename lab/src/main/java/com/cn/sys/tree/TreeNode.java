package com.cn.sys.tree;

import java.util.List;
//bootstrap treeview 节点类
public class TreeNode {
	
	private Integer id;
	
	private Integer pid;
	
	private String text;

	private String icon;

	private String selectedIcon;

	private String color;

	private String backColor;

	private String href;

	private boolean selectable;

	private List<String> tags;

	private List<TreeNode> nodes;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getSelectedIcon() {
		return selectedIcon;
	}

	public void setSelectedIcon(String selectedIcon) {
		this.selectedIcon = selectedIcon;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBackColor() {
		return backColor;
	}

	public void setBackColor(String backColor) {
		this.backColor = backColor;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public boolean getSelectable() {
//		if(this.nodes==null||this.nodes.size()==0){
//			return true;
//		}
		return true;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<TreeNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<TreeNode> nodes) {
		this.nodes = nodes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
 
	
}
