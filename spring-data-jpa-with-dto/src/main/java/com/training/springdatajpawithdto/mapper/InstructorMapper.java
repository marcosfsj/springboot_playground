package com.training.springdatajpawithdto.mapper;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.springdatajpawithdto.dto.CourseDto;
import com.training.springdatajpawithdto.dto.InstructorDto;
import com.training.springdatajpawithdto.entity.Course;
import com.training.springdatajpawithdto.entity.Instructor;

@Component
public class InstructorMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CourseMapper courseMapper;
	
	public InstructorDto convertToDto(Instructor instructor) {
		InstructorDto instructorDto = modelMapper.map(instructor, InstructorDto.class);
		instructorDto.setId(instructor.getId());
		instructorDto.setFirstName(instructor.getFirstName());
		instructorDto.setLastName(instructor.getLastName());
		instructorDto.setEmail(instructor.getEmail());
		
		Set<CourseDto> coursesDto = new HashSet<>();
		for (Course course : instructor.getCourses()) {
			coursesDto.add(courseMapper.convertToDto(course));
		}
		instructorDto.setCourses(coursesDto);
		
		return instructorDto;
	}

	public Instructor convertToEntity(InstructorDto instructorDto) throws ParseException {
		Instructor instructor = modelMapper.map(instructorDto, Instructor.class);
		instructor.setId(instructorDto.getId());
		instructor.setFirstName(instructorDto.getFirstName());
		instructor.setLastName(instructorDto.getLastName());
		instructor.setEmail(instructorDto.getEmail());
		return instructor;
	}

}
