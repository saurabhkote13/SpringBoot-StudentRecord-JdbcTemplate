package com.assimilate.studentdemo.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.assimilate.studentdemo.model.Student;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student =new Student();
		student.setRoll_number(rs.getInt("Roll_Number"));
		student.setName(rs.getString("Name"));
		student.setCity(rs.getString("City"));
		student.setEmail_id(rs.getString("Email_id"));
		student.setContact_number(rs.getString("Contact_Number"));
		return student;
		
	}

}
