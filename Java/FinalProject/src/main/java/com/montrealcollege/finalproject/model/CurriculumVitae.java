package com.montrealcollege.finalproject.model;

import java.util.ArrayList;
import java.util.List;

public class CurriculumVitae {
	
	private List<Education> schooling;
	
	private List<WorkExperience> employment;
	
	private Skills skills;
	
	private int userId;

	public CurriculumVitae(int userId) {
		this.userId = userId;
	}

	public List<Education> getSchooling() {
		return schooling;
	}

	public void setSchooling(List<Education> schooling) {
		this.schooling = schooling;
	}
	
	public void addSchooling(Education education) {
		if(schooling == null)
			schooling = new ArrayList<>();
		schooling.add(education);
	}
	
	public List<WorkExperience> getEmployment() {
		return employment;
	}

	public void setEmployment(List<WorkExperience> employment) {
		this.employment = employment;
	}
	
	public void addEmployment(WorkExperience workExperience) {
		if(employment == null)
			employment = new ArrayList<>();
		employment.add(workExperience);
	}
	
	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
}
