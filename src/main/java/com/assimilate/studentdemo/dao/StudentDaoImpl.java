package com.assimilate.studentdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.assimilate.studentdemo.dao.mappers.StudentRowMapper;
import com.assimilate.studentdemo.model.Student;
@Component
public class StudentDaoImpl implements StudentDao {
	@Autowired 
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addStudent(Student student) {
		int result = jdbcTemplate.update("insert into studentRecords(Name,City,Email_id,Contact_Number) values(?,?,?,?)",student.getName(),student.getCity(),student.getEmail_id(),student.getContact_number());
		return result;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students=jdbcTemplate.query("select * from studentRecords",new StudentRowMapper());
		return students;
	}

	@Override
	public int updateStudent(Student student) {
		int result =jdbcTemplate.update("update studentRecords set Name=?,City=?,Email_id=?,Contact_number=? where Roll_Number=?",student.getName(),student.getCity(),student.getEmail_id(),student.getContact_number(),student.getRoll_number());
		return result;
	}

	@Override
	public int deleteStudent(int roll_number) {
		int result =jdbcTemplate.update("delete from studentRecords where Roll_Number=?",roll_number);
		return result;
	}

	@Override
	public Student getStudentByRollNumber(Integer roll_number) {
		List<Student> student=jdbcTemplate.query("select * from studentRecords where Roll_number=?",new StudentRowMapper(),roll_number);
		return student.get(0);
	}

	@Override
	public List<Student> getStudentByName(String name) {
		List<Student> student=jdbcTemplate.query("select * from studentRecords where Name=?",new StudentRowMapper(),name);
		return student;
	}
}