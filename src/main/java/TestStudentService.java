import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageInfo;

import cn.hbu.stusys.model.Student;
import cn.hbu.stusys.service.IAdminService;
import cn.hbu.stusys.service.IStudentService;


public class TestStudentService {
	
	public static void main(String[] args) {
		final String xmlpath = "bean.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlpath);	
		IStudentService studentService=context.getBean(IStudentService.class);
		PageInfo<Student> result=studentService.getStudentInfoByPage(1,10);
		
	
	}
}
