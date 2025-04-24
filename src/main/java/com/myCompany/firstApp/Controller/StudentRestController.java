package com.myCompany.firstApp.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.StudentPOJO;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<StudentPOJO> listStudent;
	
	@PostConstruct
	public void loadData() {
		listStudent = new ArrayList<>();
		listStudent.add(new StudentPOJO("Hey ther","heyy"));
		listStudent.add(new StudentPOJO("sonali","vishwa") );
		listStudent.add(new StudentPOJO("nit","vishwa") );
	}
   
	// define endPoint for "/Student" - return a list of student
	
	@GetMapping("/mapping")
	public List<StudentPOJO> getStudents() {

		return listStudent;
		
	}
	
	// define endPoint or "/Student/{StudentId}" return student at index
	
	@GetMapping("/student/{studentId}")
	public StudentPOJO getStudent(@PathVariable int studentId) {
		
		// just index into the list .... keep it simple for now
		
		// check the student id again list size
		
		if((studentId >= listStudent.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - "+ studentId);
		}
		return listStudent.get(studentId);
	}
	
	
	
	
}