package cn.ysy.service.ipml;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ysy.dao.IStudentDAO;
import cn.ysy.pojo.Student;
import cn.ysy.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Resource
	private IStudentDAO studentDao;
	
	@Override
	public boolean insert(Student vo) throws Exception {
		// TODO Auto-generated method stub
		return this.studentDao.doCreate(vo);
	}

	@Override
	public boolean update(Student vo) throws Exception {
		// TODO Auto-generated method stub
		return this.studentDao.doUpdate(vo);
	}

	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		if(ids.size()==0){
		return false;
		}
		return this.studentDao.doRemoveBatch(ids);
	}

}
