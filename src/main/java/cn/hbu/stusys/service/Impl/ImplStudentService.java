package cn.hbu.stusys.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hbu.stusys.dao.StudentDAO;
import cn.hbu.stusys.model.Student;
import cn.hbu.stusys.service.IStudentService;
/**
 * @author chensiming
 *实现IStudentService接口
 */
@Service
public class ImplStudentService implements IStudentService {

	@Autowired
	StudentDAO studentDAO;
	public List<Student> getAllStudentInfo() {
		// TODO 自动生成的方法存根
		return studentDAO.getAllStudentInfo();
	}

}
