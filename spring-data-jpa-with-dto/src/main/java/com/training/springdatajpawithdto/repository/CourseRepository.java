package com.training.springdatajpawithdto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springdatajpawithdto.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	<T> List<T> findAllByInstructorId(Long id);
}