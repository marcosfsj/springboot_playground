package com.training.springdatajpanodto.service;

import java.util.List;
import java.util.Optional;

import com.training.springdatajpanodto.entity.Course;

public interface CourseService {

	public List<Course> findAll();

	public Course create(Course course);
	
	public Course update(Course course);

	public  Optional<Course> findById(Long id);

	public void deleteById(Long id);
	
}