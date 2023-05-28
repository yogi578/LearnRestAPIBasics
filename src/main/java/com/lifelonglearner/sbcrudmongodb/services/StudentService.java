package com.lifelonglearner.sbcrudmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.lifelonglearner.sbcrudmongodb.exceptions.ResourceNotFoundException;
import com.lifelonglearner.sbcrudmongodb.model.Student;
import com.lifelonglearner.sbcrudmongodb.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
// logic to create new student record in mongo DB
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	//logic to find student record from mongo DB based on passed studentID
    public Student getStudentById(int studentId) {

        Optional < Student > studentDb = this.studentRepository.findById(studentId);

        if (studentDb.isPresent()) {
            return studentDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + studentId);
        }
    }
    
    //logic to find all student records from mongo DB
    public List<Student> findAllStudentsRecords(){
    	return studentRepository.findAll();
    }
    
    //logic to update student record based on the values passed in API request body\
    public Student updateStudentRecord(Student student) {
    	
    	Optional <Student> studentDb=this.studentRepository.findById(student.getId());
    	
    	if(studentDb.isPresent()) {
    		Student studentUpdate=studentDb.get();
    		studentUpdate.setId(student.getId());
    		studentUpdate.setFirstName(student.getFirstName());
    		studentUpdate.setLastName(student.getLastName());
    		studentRepository.save(studentUpdate);
    		return studentUpdate;
    		
    		
    	}else {
    		
    	throw new ResourceNotFoundException("Resouce Not Found By ID:"+student.getId());	
    	
    	}
    	
    }

    //logic to find delete student record from mongo DB based on passed sudentID
	public void deleteStudentById(int studentId) {
		
		Optional <Student> studentDb = this.studentRepository.findById(studentId);
		if(studentDb.isPresent()) {
			 this.studentRepository.delete(studentDb.get());
		}else {
			 throw new ResourceNotFoundException("Record not found with id : " + studentId);
		}
		
	}
	
}
