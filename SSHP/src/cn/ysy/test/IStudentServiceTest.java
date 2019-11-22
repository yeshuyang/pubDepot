package cn.ysy.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ysy.pojo.Student;
import cn.ysy.service.IStudentService;
import cn.ysy.service.ipml.StudentServiceImpl;
import junit.framework.TestCase;

public class IStudentServiceTest {

	static ApplicationContext ctx;
	static{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	@Test
	public void testInsert() {
		IStudentService service=ctx.getBean("studentServiceImpl",IStudentService.class);
		Student s=new Student();
		s.setName("ะกรื");
		s.setAge(10);
		try{
			TestCase.assertEquals(service.insert(s), true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		IStudentService service=ctx.getBean("studentServiceImpl",IStudentService.class);
		Student s=new Student();
		s.setId(11158);
		s.setName("ภ๖ภ๖ ");
		s.setAge(10);
		try{
			TestCase.assertEquals(service.update(s), true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		IStudentService service=ctx.getBean("studentServiceImpl",IStudentService.class);
		Student s=new Student();
		s.setId(11158);
		Set<Integer> ids=new HashSet<Integer>();
		ids.add(11158);
		try {
			TestCase.assertEquals(service.delete(ids), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
