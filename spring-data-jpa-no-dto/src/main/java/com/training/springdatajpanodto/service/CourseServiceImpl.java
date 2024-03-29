package com.training.springdatajpanodto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.springdatajpanodto.entity.Course;
import com.training.springdatajpanodto.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Transactional
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Transactional
	public Course create(Course course) {
		return courseRepository.save(course);
	}
	
	@Transactional
	public Course update(Course course) {
		return courseRepository.save(course);
	}

	@Transactional
	public Optional<Course> findById(Long id) {
		return courseRepository.findById(id);
	}

	@Transactional
	public void deleteById(Long id) {
		courseRepository.deleteById(id);
	}
	
}