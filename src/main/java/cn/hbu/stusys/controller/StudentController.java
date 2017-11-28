package cn.hbu.stusys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hbu.stusys.model.Student;
import cn.hbu.stusys.service.IStudentService;
import cn.hbu.stusys.util.StringConst;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	IStudentService studentService;

	/**
	 * 查询自己的详细信息
	 * @param request
	 * @param id
	 * @return
	 */
	@GetMapping("/getDetailInfo")
	public String getStudentDetails(HttpServletRequest request)
	{
		Student stu=(Student) request.getSession().getAttribute(StringConst.INFO);
		request.setAttribute(StringConst.DETAIL,studentService.getStudentDetailInfo(stu.getId()));
		return "/WEB-INF/view/StuMessageDetails.jsp";
	}
	@GetMapping("/login")
	public @ResponseBody String loginStudent(HttpServletRequest request,String username,String password)
	{
		return "学生登录方法";
	}
}
