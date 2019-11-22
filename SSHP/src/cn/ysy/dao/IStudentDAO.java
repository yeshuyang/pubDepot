package cn.ysy.dao;

import java.util.Set;

import cn.ysy.pojo.Student;

public interface IStudentDAO {
   public boolean doCreate(Student vo) throws Exception; 
   public boolean doUpdate(Student vo) throws Exception;
   public boolean doRemoveBatch(Set<Integer> ids) throws Exception;
   
}
