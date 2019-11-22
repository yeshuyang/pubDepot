package cn.ysy.dao.impl;

import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import cn.ysy.dao.IStudentDAO;
import cn.ysy.pojo.Student;

@Component
public class StudentDAOImpl implements IStudentDAO {

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public boolean doCreate(Student vo) throws Exception {
		
		return sessionFactory.getCurrentSession().save(vo)!=null;
	}

	@Override
	public boolean doUpdate(Student vo) throws Exception {
		// TODO Auto-generated method stub
		String hql="UPDATE Student SET name=?,age=? where id=?";
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, vo.getName());
		query.setParameter(1, vo.getAge());
		query.setParameter(2, vo.getId());
		return query.executeUpdate()>0;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer buf=new StringBuffer();
		buf.append("DELETE FROM Student WHERE id IN(");
		Iterator<Integer> iter=ids.iterator();
		while(iter.hasNext()){
			buf.append(iter.next()).append(",");
		}
		buf.delete(buf.length()-1,buf.length()).append(")");
		Query query=this.sessionFactory.getCurrentSession().createQuery(buf.toString());
		
		return query.executeUpdate()>0;
	}

}
