package com.lifelonglearner.sbcrudmongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lifelonglearner.sbcrudmongodb.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {

	

}
