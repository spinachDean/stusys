package cn.hbu.stusys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
}
