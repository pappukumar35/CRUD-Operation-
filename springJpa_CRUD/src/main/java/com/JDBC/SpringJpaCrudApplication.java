package com.JDBC;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.JDBC.entity.Student;
import com.JDBC.service.StudentService;

@SpringBootApplication
public class SpringJpaCrudApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJpaCrudApplication.class, args);

		StudentService stdService = context.getBean(StudentService.class);
		
		/* insert section */
		
		/*
		 * Student std = new Student(); std.setName("Amit kumar"); std.setRollnum(105);
		 * std.setMarks(94.5f);
		 * 
		 * boolean status = stdService.addStudentDetails(std); if (status) {
		 * System.out.println("Student inserted successfully."); } else {
		 * System.out.println("Student insert failed."); }
		 */
		
		
		/* select section */
		/*
		 * List<Student>stdList=stdService.getAllDetails(); for(Student std:stdList) {
		 * System.out.println("Id:"+std.getId());
		 * System.out.println("Name:"+std.getName());
		 * System.out.println("Rollnum:"+std.getRollnum());
		 * System.out.println("Marks:"+std.getMarks());
		 * System.out.println("------------------------------"); }
		 */
		
		
		/* find id */
		
		/*
		 * Student std=stdService.getById(5); if(std!=null) {
		 * System.out.println("Id:"+std.getId());
		 * System.out.println("Name:"+std.getName());
		 * System.out.println("Rollnum:"+std.getRollnum());
		 * System.out.println("Marks:"+std.getMarks());
		 * System.out.println("------------------------------"); }else {
		 * System.out.println("Student data not found "); }
		 */
		
		
		/* update student section */
		/*
		 * boolean status=stdService.updateStuDetail(1, 99.5f); if(status) {
		 * System.out.println("Student details update successfully"); }else {
		 * System.out.println("Student faild error "); }
		 */
		
		
		
		/* delete student section */
		boolean status=stdService.deleteStdDetail(2);
		if(status) {
			System.out.println("Student delete successfully");
		}else {
			System.out.println("Student failed error");
		}
		
	}
}
