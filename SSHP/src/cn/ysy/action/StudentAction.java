package cn.ysy.action;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;

import cn.ysy.pojo.Student;
import cn.ysy.service.IStudentService;

@Repository
@ParentPackage("root")
@Namespace("/pages/student")
@Action(value="StudentAction")
@SuppressWarnings("serial")
public class StudentAction extends ActionSupport {
  
	@Resource
	private IStudentService studentService;
	
	private Student s=new Student();
	
	public Student getS() {
		return s;
	}

	public void insert(){
		System.out.println("[学生数据增加]数据"+this.s);
		try {
			System.out.println("[学生数据增加]业务调用"+this.studentService.insert(this.s));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(){
		System.out.println("[学生数据增加]数据"+this.s);
		try {
			System.out.println("[学生数据增加]业务调用"+this.studentService.update(this.s));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(){
		String ids=ServletActionContext.getRequest().getParameter("ids");
		
		System.out.println("[学生数据增加]数据"+ids);
		try {
			Set<Integer> set=new HashSet<Integer>();
			String result[]=ids.split("\\|");
			for(int x=0;x<result.length;x++){
				set.add(Integer.parseInt(result[x]));
			}
			System.out.println("[学生数据增加]业务调用"+this.studentService.delete(set));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
