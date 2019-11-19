package com.training.springdatajpawithdto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springdatajpawithdto.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {}