package cn.hbu.stusys.service;

import java.util.List;

import cn.hbu.stusys.model.Teacher;

/**
 * @author chensiming
 *辅导员、教学秘书接口 获取、更改老师的信息
 */
public interface ITeacherService {

	/**
	 * 以用户名获取老师的信息（包括菜单、不包括所任教班级）
	 * @param username
	 * @return
	 */
	public Teacher login(String username, String password);
	/**
	 * 获取老师所任教的班级
	 * @param username
	 * @return
	 */
	public Teacher getTeacherClasses(String username);

	
	
}
