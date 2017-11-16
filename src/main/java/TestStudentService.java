import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hbu.stusys.model.Student;
import cn.hbu.stusys.service.IStudentService;


public class TestStudentService {
	
	public static void main(String[] args) {
		final String xmlpath = "bean.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlpath);	
		IStudentService studentService=(IStudentService) context.getBean(IStudentService.class);
		List<Student> s=studentService.getAllStudentInfo();
		for(Student stu:s)
		{
			System.out.println(stu.toString());
		}
	}
}
