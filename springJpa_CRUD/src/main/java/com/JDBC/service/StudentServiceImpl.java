package com.JDBC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JDBC.entity.Student;
import com.JDBC.repository.StudentRepository;

@Service
public class StudentServiceImpl  implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public boolean addStudentDetails(Student std) {
		
		boolean status=false;
		try {
			studentRepository.save(std);
			status=true;
			
		}catch(Exception e) {
			e.printStackTrace();
			status=false;	
		}
		return status;
	}

	@Override
	public List<Student> getAllDetails() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student getById(long id) {
		Optional<Student>optional=studentRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}


	@Override
	public boolean updateStuDetail(long id, float marks) {
		Student std=getById(id);
		if(std!=null) {
			std.setMarks(marks);
			studentRepository.save(std);
			
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStdDetail(long id) {
		boolean status=false;
		try {
			studentRepository.deleteById(id);
			status=true;
		}catch(Exception e) {
			e.printStackTrace();
			status=false;
		}
		return status;
	}

}
