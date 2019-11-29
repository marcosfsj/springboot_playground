package com.training.springdatajpawithdto.repository;

import org.springframework.data.util.Streamable;

import com.training.springdatajpawithdto.entity.Instructor;

public interface InstructorRepository extends BaseRepository<Instructor, Long> {
	Streamable<Instructor> findByFirstNameContaining(String firstName);
	Streamable<Instructor> findByLastNameContaining(String lastName);
}