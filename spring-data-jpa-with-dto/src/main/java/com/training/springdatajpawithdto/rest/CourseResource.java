package com.training.springdatajpawithdto.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.springdatajpawithdto.entity.Course;
import com.training.springdatajpawithdto.rest.exception.NotFoundException;
import com.training.springdatajpawithdto.service.CourseService;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseResource {

	@Autowired
	private CourseService courseService;
	

	@GetMapping
	List<Course> findAll() {
		return courseService.findAll();
	}

	@GetMapping("/{id}")
	Course findById(@PathVariable Long id) {
		return courseService.findById(id)
				.orElseThrow(() -> new NotFoundException("Course id not found - " + id));
	}

	@PostMapping
	Course create(@RequestBody Course course) {
		course.setId(null);
		return courseService.create(course);
	}

	@PutMapping("/{id}")
	Course update(@RequestBody Course updatedCourse, @PathVariable Long id) {
		return courseService.findById(id).map(course -> {
			course.setTitle(updatedCourse.getTitle());
			return courseService.update(course);
		}).orElseThrow(() -> new NotFoundException("Course id not found - " + id));
	}

	@DeleteMapping("/{id}")
	void deleteById(@PathVariable Long id) {
		courseService.deleteById(id);
	}

}
