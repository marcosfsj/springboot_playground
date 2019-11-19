package com.training.springdatajpanodto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.springdatajpanodto.entity.Course;
import com.training.springdatajpanodto.entity.Instructor;
import com.training.springdatajpanodto.repository.CourseRepository;
import com.training.springdatajpanodto.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorRepository instructorRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Transactional
	public List<Instructor> findAll() {
		return instructorRepository.findAll();
	}
	
	@Transactional
	public List<Course> findRelatedCourses(Long id) {
		return courseRepository.findAllByInstructorId(id);
	}

	@Transactional
	public Instructor create(Instructor instructor) {
		return instructorRepository.save(instructor);
	}
	
	@Transactional
	public Instructor update(Instructor instructor) {
		return instructorRepository.save(instructor);
	}

	@Transactional
	public Optional<Instructor> findById(Long id) {
		return instructorRepository.findById(id);
	}

	@Transactional
	public void deleteById(Long id) {
		instructorRepository.deleteById(id);
	}

}