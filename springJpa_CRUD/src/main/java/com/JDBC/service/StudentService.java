package com.JDBC.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.JDBC.entity.Student;

@Service
public interface StudentService {
	
	public boolean addStudentDetails(Student std);
	
	public List<Student> getAllDetails();
	
	public Student getById(long id);
	
	public boolean updateStuDetail(long id,float marks);
	
	public boolean deleteStdDetail(long id);

}
