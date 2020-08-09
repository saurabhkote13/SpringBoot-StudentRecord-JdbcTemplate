package com.assimilate.studentdemo.dao;

import java.util.List;

import com.assimilate.studentdemo.model.Student;

public interface StudentDao {
	
	public int addStudent(Student student);
	public List<Student> getAllStudents();
	public int updateStudent(Student student);
	public int deleteStudent(int roll_number);
	public Student getStudentByRollNumber(Integer roll_number);
	public List<Student> getStudentByName(String name);

	
}
