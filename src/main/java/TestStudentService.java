import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hbu.stusys.dao.StudentDAO;
import cn.hbu.stusys.model.Student;
import cn.hbu.stusys.service.CacheTestService;
import cn.hbu.stusys.service.IAdminService;


public class TestStudentService {
	
	public static void main(String[] args) {
		final String xmlpath = "bean.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlpath);	
		//IStudentService studentService=context.getBean(IStudentService.class);
//		IAdminService adminService=context.getBean(IAdminService.class);
//		Student stu=new Student();
//		stu.setName("陈思明");
		//stu.setYear(2015);
//		System.out.println(adminService.getStudentInfoByPage(1,20,stu).getList());
//		  assert number >= 0 : "number must be non-negative";
		CacheTestService cacheTestService=context.getBean(CacheTestService.class);
		
		System.out.println(cacheTestService.getLists());
		System.out.println(cacheTestService.getLists());
		System.out.println(cacheTestService.getLists());
		System.out.println(cacheTestService.getLists());
		System.out.println(cacheTestService.getLists());
	}
}
