package com.crud.me.springbootextended.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.crud.me.springbootextended.entity.Student;
import com.crud.me.springbootextended.reopsitory.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private final StudentRepository repository;
	
	private StudentService( StudentRepository repository) {
		this.repository=repository;
	}
	
	//get all students
	public ResponseEntity<List<Student>> getAllStudents(){
		try {
			List<Student> students=new ArrayList<Student>();
			repository.findAll().forEach(students::add);
			
			if(students.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(students,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//get student by id
	public ResponseEntity<Student> getStudentById(UUID id) {
	    try {
	        Optional<Student> student = repository.findById(id);
	        
	        if (student.isPresent()) {
	            return new ResponseEntity<>(student.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	public ResponseEntity<Student> addStudent(Student student){
		Student objStudent= repository.save(student);
		
		return new ResponseEntity<>(objStudent,HttpStatus.OK);
	}

	public ResponseEntity<Student> updateStudentById(UUID id, Student student) {
		Optional<Student> oldData = repository.findById(id);
		if(oldData.isPresent()) {
			Student updatedData=oldData.get();
			updatedData.setFirstName(student.getFirstName());
			updatedData.setLastName(student.getLastName());
			
			Student objStudent=repository.save(updatedData);
			return new ResponseEntity<>(objStudent,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<HttpStatus> deleteByID(@PathVariable UUID id){
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
}
