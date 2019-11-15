package com.training.springdatajparest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springdatajparest.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {}