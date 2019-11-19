package com.training.springdatajpawithdto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id @GeneratedValue
	private Long id;
	private String title;
	private Long instructorId;
	
	public Course() {}
	
	public Course(String title, Long instructorId) {
		this.title = title;
		this.instructorId = instructorId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructorId=" + instructorId + "]";
	}

}
