package cn.hbu.stusys.service;

import java.util.List;

import cn.hbu.stusys.model.Student;
import cn.hbu.stusys.model.StudentDetail;

import com.github.pagehelper.PageInfo;

/**
 * @author chensiming
 * 有关学生信息增删改查的服务层
 */
public interface IStudentService {
	/**
	 * 通过学号获取学生详细信息
	 * @param id
	 * @return
	 */
	public StudentDetail getStudentDetailInfo(String id);
}
