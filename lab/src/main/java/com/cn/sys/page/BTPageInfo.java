package com.cn.sys.page;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class BTPageInfo<T> extends PageInfo<T> {

	public BTPageInfo(List<T> list){
		super(list);
	}
	public List<T> getRows() {
		return super.getList();
	}

	public void setRows(List<T> rows) {
		super.setList(rows);
	}
}
