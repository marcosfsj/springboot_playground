package com.training.springdatajpawithdto.mapper;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.springdatajpawithdto.dto.InstructorDto;
import com.training.springdatajpawithdto.entity.Instructor;

@Component
public class InstructorMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public InstructorDto convertToDto(Instructor instructor) {
		InstructorDto instructorDto = modelMapper.map(instructor, InstructorDto.class);
		return instructorDto;
	}

	public Instructor convertToEntity(InstructorDto instructorDto) throws ParseException {
		Instructor instructor = modelMapper.map(instructorDto, Instructor.class);
		return instructor;
	}

}
