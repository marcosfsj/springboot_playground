package com.training.springdatajpawithdto.repository;

import java.util.List;

import com.training.springdatajpawithdto.entity.Course;

public interface CourseRepository extends BaseRepository<Course, Long> {
	<T> List<T> findAllByInstructorId(Long id);
}