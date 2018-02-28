package cn.hbu.stusys.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hbu.stusys.dao.TeacherDAO;
import cn.hbu.stusys.model.Teacher;
import cn.hbu.stusys.service.ITeacherService;

@Service
public class ImplTeacherService implements ITeacherService {
	@Autowired
	TeacherDAO teacherDAO;

	public Teacher login(String username, String password) {
		String realPassword = teacherDAO.getPassword(username);
		if (password.equals(realPassword))
			return teacherDAO.getTeacherInfo(username);
		else
			return null;
	}
	
	public Teacher getTeacherClasses(String username) {
		// TODO 自动生成的方法存根
		return null;
	}



}
