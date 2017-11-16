package cn.hbu.stusys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.hbu.stusys.model.Student;

/**
 * @author chensiming
 *方法：
 *getAllxxx获取全部信息
 *getxxxByaaa()通过aaa获取xxx
 */
@Repository
public interface StudentDAO {
	/**
	 * 获取全部的学生信息
	 * @return 学生信息的列表
	 */
	public List<Student> getAllStudentInfo();
	
}
