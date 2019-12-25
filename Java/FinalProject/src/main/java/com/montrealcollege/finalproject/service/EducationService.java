package com.montrealcollege.finalproject.service;

import java.util.List;

import com.montrealcollege.finalproject.model.Education;

public interface EducationService {
	
	public void addEducation(Education education);
	
	public void deleteEducation(int eduId);
	
	public List<Education> listEducations();
	
	public List<Education> listEducationByUser(int userId);
	
	public Education updateEducation(Education education);
	
	public Education getEducation(int eduId);
}
