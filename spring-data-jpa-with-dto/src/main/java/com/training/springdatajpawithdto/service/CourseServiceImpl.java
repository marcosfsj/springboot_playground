package com.training.springdatajpawithdto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.springdatajpawithdto.entity.Course;
import com.training.springdatajpawithdto.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Transactional
	public List<Course> findAll() {
		return courseRepository.findAll();
	}
	
	@Transactional
	public List<Course> findAllByInstructorId(Long instructorId) {
		return courseRepository.findAllByInstructorId(instructorId);
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