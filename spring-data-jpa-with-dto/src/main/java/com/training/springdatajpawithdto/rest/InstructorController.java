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
import com.training.springdatajpawithdto.entity.Instructor;
import com.training.springdatajpawithdto.rest.exception.NotFoundException;
import com.training.springdatajpawithdto.service.InstructorService;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {

	@Autowired
	private InstructorService instructorService;
	

	@GetMapping
	List<Instructor> findAll() {
		return instructorService.findAll();
	}

	@GetMapping("/{id}")
	Instructor findById(@PathVariable Long id) {
		return instructorService.findById(id)
				.orElseThrow(() -> new NotFoundException("Instructor id not found - " + id));
	}
	
	@GetMapping("/{id}/courses")
	List<Course> findRelatedCourses(@PathVariable Long id) {
		return instructorService.findRelatedCourses(id);
	}

	@PostMapping
	Instructor create(@RequestBody Instructor instructor) {
		instructor.setId(null);
		return instructorService.create(instructor);
	}

	@PutMapping("/{id}")
	Instructor update(@RequestBody Instructor newInstructor, @PathVariable Long id) {
		return instructorService.findById(id).map(instructor -> {
			instructor.setFirstName(newInstructor.getFirstName());
			instructor.setLastName(newInstructor.getLastName());
			instructor.setEmail(newInstructor.getEmail());
			instructor.setAge(newInstructor.getAge());
			return instructorService.update(instructor);
		}).orElseThrow(() -> new NotFoundException("Instructor id not found - " + id));
	}

	@DeleteMapping("/{id}")
	void deleteById(@PathVariable Long id) {
		instructorService.deleteById(id);
	}

}
