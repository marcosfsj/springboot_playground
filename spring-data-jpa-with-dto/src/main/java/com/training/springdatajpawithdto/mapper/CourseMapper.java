package com.training.springdatajpawithdto.mapper;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.springdatajpawithdto.dto.CourseDto;
import com.training.springdatajpawithdto.entity.Course;

@Component
public class CourseMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CourseDto convertToDto(Course course) {
		CourseDto courseDto = modelMapper.map(course, CourseDto.class);
//		 postDto.setSubmissionDate(post.getSubmissionDate(), 
//			        userService.getCurrentUser().getPreference().getTimezone());
		return courseDto;
	}

	public Course convertToEntity(CourseDto courseDto) throws ParseException {
		Course course = modelMapper.map(courseDto, Course.class);
//		post.setSubmissionDate(postDto.getSubmissionDateConverted(
//			      userService.getCurrentUser().getPreference().getTimezone()));
		return course;
	}

}
