package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Prakash","Choudhary"));
		theStudents.add(new Student("Srinath","Kuruth"));
		theStudents.add(new Student("Puja","Bharti"));
	}
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if ((studentId >= theStudents.size()) || (studentId <0)){
			throw new StudentNotFoundException("student ID not found - " + studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	
}
