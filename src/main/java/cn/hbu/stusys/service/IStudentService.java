package cn.hbu.stusys.service;

import java.util.List;

import cn.hbu.stusys.model.Student;

/**
 * @author chensiming
 * 有关学生信息增删改查的服务层
 */
public interface IStudentService {
	/**
	 * 查询所有学生的基本信息
	 * @return
	 */
	public List<Student> getAllStudentInfo();
}
