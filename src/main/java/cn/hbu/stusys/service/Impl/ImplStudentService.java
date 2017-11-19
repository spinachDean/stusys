package cn.hbu.stusys.service.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hbu.stusys.dao.StudentDAO;
import cn.hbu.stusys.model.Student;
import cn.hbu.stusys.model.StudentDetail;
import cn.hbu.stusys.service.IStudentService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * @author chensiming
 *实现IStudentService接口
 */
@Service
public class ImplStudentService implements IStudentService {
	Logger logger=Logger.getLogger(this.getClass());
	@Autowired
	StudentDAO studentDAO;
	public List<Student> getAllStudentInfo() {
		// TODO 自动生成的方法存根
		return studentDAO.getAllStudentInfo();
	}

	public synchronized PageInfo<Student> getStudentInfoByPage(Integer pageNo,
			Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);//启动分页插件
	    List<Student> list=studentDAO.getAllStudentInfo();
	    PageInfo<Student> page = new PageInfo<Student>(list);
	    return page;
	}

	public StudentDetail getStudentDetailInfo(String id) {
		if(id==null||id.equals("")||id.length()!=11){
			logger.info("学号参数传入错误");
			return null;
		}
		return studentDAO.getStudentDetailInfo(id);
	}

}
