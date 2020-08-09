package com.assimilate.studentdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assimilate.studentdemo.dao.StudentDao;
import com.assimilate.studentdemo.model.Student;
@Component
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao studentDao;

	@Override
	public int addStudent(Student student) {
		int result= studentDao.addStudent(student);
		return result;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students=studentDao.getAllStudents();
		return students;
	}

	@Override
	public int updateStudent(Student student) {
		int result=studentDao.updateStudent(student);
		return result;
	}

	@Override
	public int deleteStudent(int roll_number) {
		int result=studentDao.deleteStudent(roll_number);
		return result;
	}

	@Override
	public Student getStudentByRollNumber(int roll_number) {
		Student student=studentDao.getStudentByRollNumber(roll_number);
		return student;
	}

	@Override
	public List<Student> getStudentByName(String name) {
		List<Student> students=studentDao.getStudentByName(name);
		return students;
	}
	}
