package com.JDBC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JDBC.entity.Student;

public interface StudentRepository  extends JpaRepository<Student,Long>{

}
