package com.montrealcollege.finalproject.service;

import java.util.List;

import com.montrealcollege.finalproject.model.WorkExperience;

public interface WorkExpericenceService {
	
	public void addWorkExperience(WorkExperience we);

	public void deleteWorkExperience(int weId);

	public List<WorkExperience> listWorkExperience();

	public List<WorkExperience> listWorkExperienceByUser(int userId);

	public WorkExperience updateWorkExperience(WorkExperience we);

	public WorkExperience getWorkExperience(int weId);
}
