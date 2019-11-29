package com.training.springdatajpawithdto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.springdatajpawithdto.entity.Instructor;
import com.training.springdatajpawithdto.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorRepository instructorRepository;
	
	@Transactional
	public List<Instructor> findAll() {
		return instructorRepository.findAll();
	}
	
	@Transactional
	public Page<Instructor> findAllPaginated(int page, int pageSize) {
		return instructorRepository.findAll(PageRequest.of(page, pageSize));
	}
	
	@Transactional
	public Instructor create(Instructor instructor) {
		return instructorRepository.save(instructor);
	}
	
	@Transactional
	public Instructor update(Instructor instructor) {
		return instructorRepository.save(instructor);
	}

	@Transactional
	public Optional<Instructor> findById(Long id) {
		return instructorRepository.findById(id);
	}

	@Transactional
	public void deleteById(Long id) {
		instructorRepository.deleteById(id);
	}

}