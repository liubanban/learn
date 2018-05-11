package com.cn.lab.model;

import java.util.Date;

public class Teacher {
    /**
     * 主键 自增
     * db字段:teacher.id
     */
    private Integer id;

    /**
     * 姓名
     * db字段:teacher.tname
     */
    private String tname;

    /**
     * 性别 0 男 1 女
     * db字段:teacher.tsex
     */
    private String tsex;

    /**
     * 生日
     * db字段:teacher.tbirthday
     */
    private Date tbirthday;

    /**
     * 主键 自增
     * teacher.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键 自增
     * teacher.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 姓名
     * teacher.tname
     */
    public String getTname() {
        return tname;
    }

    /**
     * 姓名
     * teacher.tname
     */
    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    /**
     * 性别 0 男 1 女
     * teacher.tsex
     */
    public String getTsex() {
        return tsex;
    }

    /**
     * 性别 0 男 1 女
     * teacher.tsex
     */
    public void setTsex(String tsex) {
        this.tsex = tsex == null ? null : tsex.trim();
    }

    /**
     * 生日
     * teacher.tbirthday
     */
    public Date getTbirthday() {
        return tbirthday;
    }

    /**
     * 生日
     * teacher.tbirthday
     */
    public void setTbirthday(Date tbirthday) {
        this.tbirthday = tbirthday;
    }
}