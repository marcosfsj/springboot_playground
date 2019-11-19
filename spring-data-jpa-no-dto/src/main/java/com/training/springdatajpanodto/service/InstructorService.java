package com.training.springdatajpanodto.service;

import java.util.List;
import java.util.Optional;

import com.training.springdatajpanodto.entity.Course;
import com.training.springdatajpanodto.entity.Instructor;

public interface InstructorService {

	public List<Instructor> findAll();
	
	public List<Course> findRelatedCourses(Long id);

	public Instructor create(Instructor instructor);
	
	public Instructor update(Instructor instructor);

	public  Optional<Instructor> findById(Long id);

	public void deleteById(Long id);
	
}