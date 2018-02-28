package cn.hbu.stusys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mchange.lang.StringUtils;

import cn.hbu.stusys.service.ITeacherService;
import cn.hbu.stusys.util.StringConst;

/**
 * @author chensiming
 *
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	ITeacherService teacherService;
	@GetMapping("/login")
	public @ResponseBody String loginTeacher(HttpServletRequest request,String username,String password){
		//测试账号
		request.getSession().setAttribute(StringConst.USER,teacherService.login("admin","admin"));
		return "模拟教师登录成功";
	}
	
}
