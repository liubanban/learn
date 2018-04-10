package com.cn.lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
/**
 * 加载文件,获取spring容器
 * @author liubanban
 *
 */
public class BeanHolder {
	ApplicationContext ac = new FileSystemXmlApplicationContext("/src/main/resources/spring/applicationContext.xml");
}
