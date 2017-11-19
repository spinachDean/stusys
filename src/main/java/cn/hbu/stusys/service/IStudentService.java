package cn.hbu.stusys.service;

import java.util.List;

import cn.hbu.stusys.model.Student;

import com.github.pagehelper.PageInfo;

/**
 * @author chensiming
 * 有关学生信息增删改查的服务层
 */
public interface IStudentService {
	/**
	 * 查询所有学生的基本信息(不常用)
	 * @return
	 */
	public List<Student> getAllStudentInfo();
	/**
	 * 根据页码和页大小查询学生信息 使用了pageHelper插件
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageInfo<Student> getStudentInfoByPage(Integer pageNo,Integer pageSize);
}
