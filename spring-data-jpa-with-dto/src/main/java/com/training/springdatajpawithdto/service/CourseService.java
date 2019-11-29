package com.training.springdatajpawithdto.service;

import java.util.List;
import java.util.Optional;

import com.training.springdatajpawithdto.entity.Course;

public interface CourseService {

	public List<Course> findAll();
	
	public List<Course> findAllByInstructorId(Long instructorId);

	public Course create(Course course);
	
	public Course update(Course course);

	public  Optional<Course> findById(Long id);

	public void deleteById(Long id);
	
}