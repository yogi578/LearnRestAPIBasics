package com.lifelonglearner.sbcrudmongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lifelonglearner.sbcrudmongodb.model.Student;
import com.lifelonglearner.sbcrudmongodb.repository.StudentRepository;
import com.lifelonglearner.sbcrudmongodb.services.StudentService;

@RestController
public class StudentController {

	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/students/createStudents")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		return ResponseEntity.ok().body(this.studentService.createStudent(student));
	}
	
	
	 @GetMapping("/students/{id}")
	    public ResponseEntity < Student > getStudentByID(@PathVariable int id) {
	        return ResponseEntity.ok().body(studentService.getStudentById(id));
	    }
	 
	 @GetMapping("/students")
	 public ResponseEntity<List<Student>> findAllStudentRecords(){
		 return ResponseEntity.ok().body(studentService.findAllStudentsRecords());
	 }
	 
	 @PutMapping("/students/updateStudentRecord")
	 public ResponseEntity<Student> updateStudentRecord(@RequestBody Student student){
		 return ResponseEntity.ok().body(this.studentService.updateStudentRecord(student));
	 }
	 
	 @DeleteMapping("/students/{id}")
	 public HttpStatus deleteStudentByID(@PathVariable int id){
		 this.studentService.deleteStudentById(id);
		 System.out.println("Student Record Deleted!");
		return HttpStatus.OK;
	 }
	 
	 
	
	
	
	}

