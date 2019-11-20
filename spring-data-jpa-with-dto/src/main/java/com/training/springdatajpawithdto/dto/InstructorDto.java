package com.training.springdatajpawithdto.dto;

import java.util.List;

public class InstructorDto {
	
//	private static final SimpleDateFormat dateFormat
//    = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private int age;
	private List<CourseDto> courses;
		
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public List<CourseDto> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDto> courses) {
		this.courses = courses;
	}
	
//	  public Date getSubmissionDateConverted(String timezone) throws ParseException {
//	        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
//	        return dateFormat.parse(this.date);
//	    }
//	 
//	    public void setSubmissionDate(Date date, String timezone) {
//	        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
//	        this.date = dateFormat.format(date);
//	    }
	
}
