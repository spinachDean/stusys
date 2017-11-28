package cn.hbu.stusys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.hbu.stusys.model.Student;
import cn.hbu.stusys.model.StudentDetail;

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
	public List<Student> getAllStudentInfo(@Param("stu")Student stu);
	/**
	 * 通过学生学号获取学生详细信息
	 * @param id
	 * @return 只返回一个信息
	 */
	public StudentDetail getStudentDetailInfo(@Param("id")String id);
	
	
}
