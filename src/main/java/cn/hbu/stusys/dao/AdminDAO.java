package cn.hbu.stusys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.hbu.stusys.model.Clazz;
import cn.hbu.stusys.model.Student;

/**
 * @author chensiming
 * 管理者数据操作，教学秘书和团委老师可以使用的接口
 */
public interface AdminDAO {
	
	/**
	 * 可以批量插入学生信息和默认密码
	 * @param id
	 * @param password
	 * @return 成功插入的条数
	 */
	public int batchInsertStudents(@Param("ids")List<String> ids,@Param("password")String password);
	/**
	 * 更改班级的辅导员
	 * @param username
	 * @param classes
	 * @return
	 */
	public int updateClassesTeacher(@Param("username")String username,@Param("classes")List<Integer> classes);
	/**
	 * 根据条件所有班级的信息
	 * @return
	 */
	public List<Clazz> getClassesInfo(@Param("clazz")Clazz clazz);
	/**
	 * 添加班级信息
	 * @param clazz
	 * @return
	 */
	public int addClass(@Param("clazz")Clazz clazz);
	/**
	 * 修改班级信息
	 * @param clazz
	 * @return
	 */
	public int updateClass(@Param("clazz")Clazz clazz);
}
