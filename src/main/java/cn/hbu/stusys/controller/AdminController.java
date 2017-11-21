package cn.hbu.stusys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 管理员控制层，所需要权限最高
 * @author chensiming
 *
 */
@Controller
public class AdminController {
	/**
	 * 临时方法 跳转到管理页面 暂时不做检查
	 * @return
	 */
	@GetMapping("/admin")
	public String admin()
	{
		return "/WEB-INF/view/admin.jsp";
	}

}
