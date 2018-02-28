package cn.hbu.stusys.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hbu.stusys.dao.AdminDAO;
import cn.hbu.stusys.dao.StudentDAO;
import cn.hbu.stusys.model.Clazz;
import cn.hbu.stusys.model.Student;
import cn.hbu.stusys.service.IAdminService;
import cn.hbu.stusys.util.MD5Util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ImplAdminService implements IAdminService {
	Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	AdminDAO adminDAO;
	@Autowired
	StudentDAO studentDAO;
	@Transactional
	public int batchInsertStudents(String begin, String end, String password) {
		Long first, last;
		try {
			first = new Long(begin);
			last = new Long(end);
		} catch (Exception e) {
			logger.error("批量插入时，起止学号传入有错误");
			return 0;
		}
		if (last < first) {
			logger.info("批量插入时，结束学号比开始学号小");
			return 0;
		}
		List<String> ids = new ArrayList<String>();
		while (last >= first) {
			ids.add(first + "");
			first++;
		}
		return adminDAO.batchInsertStudents(ids,MD5Util.EncoderByMd5(password));

	}

	public List<Student> getAllStudentInfo(Student stu) {
		// TODO 自动生成的方法存根
		return studentDAO.getAllStudentInfo(stu);
	}
	
	public synchronized PageInfo<Student> getStudentInfoByPage(Integer pageNo,
			Integer pageSize,Student student) {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);//启动分页插件
	    List<Student> list=studentDAO.getAllStudentInfo(student);
	    PageInfo<Student> page = new PageInfo<Student>(list);
	    return page;
	}
	@Transactional
	public int updateClassesTeacher(String username,List<Integer> classes) {
		
		return adminDAO.updateClassesTeacher(username, classes);
	}

	public List<Clazz> getClassesInfo(Clazz clazz) {
		// TODO 自动生成的方法存根
		return adminDAO.getClassesInfo(clazz);
	}



}
