import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hbu.stusys.dao.AdminDAO;
import cn.hbu.stusys.model.Clazz;
import cn.hbu.stusys.service.IAdminService;


public class TestAdmin {

	@Test
	public void Test1()
	{
		final String xmlpath = "bean.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlpath);	
		IAdminService adminService=context.getBean(IAdminService.class);
		List<Integer> classes=new ArrayList<Integer>();
		classes.add(3);
		adminService.updateClassesTeacher("test2", classes);
	}
	@Test
	public void Test2()
	{
		final String xmlpath = "bean.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlpath);	
		IAdminService adminService=context.getBean(IAdminService.class);

		System.out.println(adminService.getClassesInfo(null));
	}
	@Test
	public void Test3()
	{
		final String xmlpath = "bean.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlpath);	
		IAdminService adminService=context.getBean(IAdminService.class);
		AdminDAO adminDAO=context.getBean(AdminDAO.class);
		Clazz clazz=new Clazz();
		clazz.setCollegeID(1);
		clazz.setName("15网工2班");
		clazz.setTeacher("zhaohong");
		clazz.setYear(2015);
		adminDAO.addClass(clazz);
		System.out.println(clazz.getClassID());
	}
	
	
}
