package com.training.springdatajpawithdto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.training.springdatajpawithdto.entity.Course;
import com.training.springdatajpawithdto.entity.Instructor;

public interface InstructorService {

	public List<Instructor> findAll();
	
	public Page<Instructor> findAllPaginated(int page, int pageSize);
	
	public List<Course> findRelatedCourses(Long id);

	public Instructor create(Instructor instructor);
	
	public Instructor update(Instructor instructor);

	public  Optional<Instructor> findById(Long id);

	public void deleteById(Long id);
	
}