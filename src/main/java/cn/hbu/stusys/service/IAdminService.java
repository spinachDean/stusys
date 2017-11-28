package cn.hbu.stusys.service;

import java.util.List;

import cn.hbu.stusys.model.Student;
import cn.hbu.stusys.model.StudentDetail;

import com.github.pagehelper.PageInfo;

/**
 * @author chensiming
 *管理服务层，由教学秘书和管理员使用
 */
public interface IAdminService {
	/**
	 * 批量插入学生登录账号（学号）和密码
	 * @param 开始学号，结束学号，默认密码
	 * @return 影响的行数
	 */
	public int batchInsertStudents(String begin,String end,String password);
	/**
	 * 查询所有学生的基本信息(不常用)
	 * @return
	 */
	public List<Student> getAllStudentInfo(Student stu);
	/**
	 * 根据页码和页大小查询学生信息 使用了pageHelper插件
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageInfo<Student> getStudentInfoByPage(Integer pageNo,Integer pageSize,Student student);


}
