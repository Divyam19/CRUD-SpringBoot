package com.crud.me.springbootextended.controller;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.me.springbootextended.entity.Student;
import com.crud.me.springbootextended.service.StudentService;


@RestController
public class StudentController {
	
	

	
	@Autowired
	private final StudentService studentService;
	
	private StudentController(StudentService studentService) {
		this.studentService=studentService;
	}
	
	@GetMapping("/getallstudents")
	public ResponseEntity<List<Student>> getAllStudentsService(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/getstudent/{id}")
	public ResponseEntity<Student> getStudentsByIdService(@PathVariable UUID id){
		return studentService.getStudentById(id);
	}
	
	@PostMapping("/addstudent")
	public ResponseEntity<Student> addStudentService(@RequestBody Student student){
		return studentService.addStudent(student);
	}
	
	@PostMapping("/updatestudent/{id}")
	public ResponseEntity<Student> updateStudentByIdService(@PathVariable UUID id, @RequestBody Student student){
		return studentService.updateStudentById(id,student);
	}

	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<HttpStatus> deleteStudentByIdService(@PathVariable UUID id){
		return studentService.deleteByID(id);
	}
}
