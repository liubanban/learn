package com.cn.lab.dao;

import com.cn.lab.model.Teacher;

public interface TeacherMapper {
    /**
     * 按照主键进行删除！
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存数据！
     */
    int insert(Teacher record);

    /**
     * 按照model保存数据！
     */
    int insertSelective(Teacher record);

    /**
     * 按照主键查找！
     */
    Teacher selectByPrimaryKey(Integer id);

    /**
     * 按照model更新数据！
     */
    int updateByPrimaryKeySelective(Teacher record);

    /**
     * 按照主键更新数据！
     */
    int updateByPrimaryKey(Teacher record);
}