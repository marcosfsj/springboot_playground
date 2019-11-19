package com.training.springdatajpawithdto.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.springdatajpawithdto.dto.CourseDto;
import com.training.springdatajpawithdto.dto.InstructorDto;
import com.training.springdatajpawithdto.entity.Instructor;
import com.training.springdatajpawithdto.mapper.CourseMapper;
import com.training.springdatajpawithdto.mapper.InstructorMapper;
import com.training.springdatajpawithdto.rest.exception.NotFoundException;
import com.training.springdatajpawithdto.service.InstructorService;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {

	@Autowired
	private InstructorService instructorService;

	@Autowired
	private InstructorMapper instructorMapper;

	@Autowired
	private CourseMapper courseMapper;

	@GetMapping
	List<InstructorDto> findAll() {
		List<Instructor> instructors = instructorService.findAll();
		return instructors.stream().map(instructor -> instructorMapper.convertToDto(instructor))
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	InstructorDto findById(@PathVariable Long id) {
		Instructor instructor = instructorService.findById(id)
				.orElseThrow(() -> new NotFoundException("Instructor id not found - " + id));
		return instructorMapper.convertToDto(instructor);
	}

	@GetMapping("/{id}/courses")
	List<CourseDto> findRelatedCourses(@PathVariable Long id) {
		return instructorService.findRelatedCourses(id).stream().map(course -> courseMapper.convertToDto(course))
				.collect(Collectors.toList());
	}

	@PostMapping
	InstructorDto create(@RequestBody Instructor instructor) {
		instructor.setId(null);
		return instructorMapper.convertToDto(instructorService.create(instructor));
	}

	@PutMapping("/{id}")
	InstructorDto update(@RequestBody InstructorDto newInstructorDto, @PathVariable Long id) {
		return instructorService.findById(id).map(instructor -> {
			instructor.setFirstName(newInstructorDto.getFirstName());
			instructor.setLastName(newInstructorDto.getLastName());
			instructor.setEmail(newInstructorDto.getEmail());
			instructor.setAge(newInstructorDto.getAge());
			return instructorMapper.convertToDto(instructorService.update(instructor));
		}).orElseThrow(() -> new NotFoundException("Instructor id not found - " + id));
	}

	@DeleteMapping("/{id}")
	void deleteById(@PathVariable Long id) {
		instructorService.deleteById(id);
	}

}
