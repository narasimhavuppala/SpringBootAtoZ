package com.example.Springbootcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Springbootcrud.model.Student;
import com.example.Springbootcrud.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo repo;

	public Student getStudent(Integer studnetId) {
		return repo.getOne(studnetId);
	}

	@Transactional
	public Student createStudent(Student obj) {
		return repo.save(obj);

	}

}
