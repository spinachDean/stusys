package cn.hbu.stusys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hbu.stusys.service.IStudentService;
import cn.hbu.stusys.util.StringConst;

@Controller
public class StudentController {
	/**
	 * 学生信息分页管理
	 * 权限：教学秘书、团委 (admin)
	 * @return
	 */
	@Autowired
	IStudentService studentService;
	@GetMapping("/admin/manageInfo/{page}")
	public String ge1tAllStudentInfo(HttpServletRequest request,@PathVariable("page")Integer page)
	{
		if(page==null)page=1;
		request.setAttribute(StringConst.INFO,studentService.getAllStudentInfo());
		return "/WEB-INF/view/StuMessageManage.jsp";
	}
	@GetMapping("/admin/getStudentDetail/{id}")
	public String getStudentDetail(HttpServletRequest request,@PathVariable(value="id",required=true)String id)
	{
		request.setAttribute(StringConst.DETAIL,studentService.getStudentDetailInfo(id));
		return "/WEB-INF/view/StuMessageDetails.jsp";
	}
}
