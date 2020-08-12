package com.assimilate.studentdemo.restservices;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assimilate.studentdemo.model.Student;
import com.assimilate.studentdemo.services.StudentService;

@CrossOrigin
@RestController
public class StudentRestController {
	private static final Logger LOGGER=LoggerFactory.getLogger(StudentRestController.class);
@Autowired 
private StudentService studentservice;
@GetMapping("/api/student/getAll")
public ResponseEntity<Object> getAllStudents(){
	try
	{
		List<Student> students =studentservice.getAllStudents();
		if(students.isEmpty())
		{
			LOGGER.debug("student list is empty");
			return new ResponseEntity<Object>("list of students is empty",HttpStatus.NO_CONTENT);
		}
		LOGGER.debug("displaying list of students:"+students);
		return new ResponseEntity<Object>(students,HttpStatus.OK);
	}catch(Exception e)
	{
		LOGGER.error("error while creating student",e);
		return new ResponseEntity<Object>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PostMapping("/api/student/create")
public Student createStudent(@RequestBody Student student)
{
	studentservice.addStudent(student);
	LOGGER.info("creating student:"+student);
	return student;
}

@PutMapping("/api/student/update")
	public Student updateStudent(@RequestBody Student student)
	{
		studentservice.updateStudent(student);
		LOGGER.debug("updating Student:"+student);
		return student;
	}

@DeleteMapping("/api/student/delete/{roll_number}")
public ResponseEntity<Object> deleteStudent(@PathVariable("roll_number") Integer roll_number)
{
	try {
		int result=studentservice.deleteStudent(roll_number);
		LOGGER.debug("deleting user of roll number:"+roll_number);
		return new ResponseEntity<Object>(result,HttpStatus.OK);
	}catch(Exception e)
	{
		LOGGER.error("error while deleting Student");
		return new ResponseEntity<Object>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping("/api/student/getbyrollnumber")
public ResponseEntity<Object> getStudentByRollNumber(@RequestParam("roll_number") int roll_number)
{
	try
	{
		Student student = studentservice.getStudentByRollNumber(roll_number);
	if(student!=null)
	{
		LOGGER.info("getting student by roll number"+student);
		return new ResponseEntity<Object>(student,HttpStatus.OK);
	}
	String message="student not found with roll number:"+roll_number;
	LOGGER.info("student not found with roll number"+roll_number);
	return new ResponseEntity<Object>(message,HttpStatus.NO_CONTENT);
	}catch(Exception e)
	{
		LOGGER.error("error while getting student by roll number");
		return new ResponseEntity<Object>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping("/api/student/getstudentbyname")
public ResponseEntity<Object> getStudentByName(String name)
{
	try
	{
		List<Student> student = studentservice.getStudentByName(name);
		if(student!=null)
		{
			LOGGER.debug("getting Student by name"+student);
			return new ResponseEntity<Object>(student,HttpStatus.OK);
		}
		String message="student not found with the name:"+name;
		LOGGER.info("student not found with name"+name);
		return new ResponseEntity<Object>(message,HttpStatus.NO_CONTENT);
	}catch(Exception e)
	{
		LOGGER.error("error while getting student by name");
		return new ResponseEntity<Object>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}