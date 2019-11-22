package cn.ysy.service;

import java.util.Set;

import cn.ysy.pojo.Student;

public interface IStudentService {
 public boolean insert(Student vo) throws Exception;
 public boolean update(Student vo) throws Exception;
 public boolean delete(Set<Integer> ids) throws Exception;
}
