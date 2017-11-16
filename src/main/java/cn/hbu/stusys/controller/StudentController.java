package cn.hbu.stusys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hbu.stusys.service.IStudentService;

@Controller
public class StudentController {
	/**
	 * 学生信息管理
	 * 权限：教学秘书、团委
	 * @return
	 */
	@Autowired
	IStudentService studentService;
	@GetMapping("/manageInfo.action")
	public String getAllStudentInfo(HttpServletRequest request)
	{
		request.setAttribute("info",studentService.getAllStudentInfo());
		return "/WEB-INF/StuMessageManage.jsp";
		
	}
}
