package cn.hbu.stusys.service;

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

}
