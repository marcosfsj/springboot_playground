package com.training.springdatajpanodto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springdatajpanodto.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {}