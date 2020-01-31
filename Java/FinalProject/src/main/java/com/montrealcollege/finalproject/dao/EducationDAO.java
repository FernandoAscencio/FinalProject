package com.montrealcollege.finalproject.dao;

import java.util.List;

import com.montrealcollege.finalproject.model.Education;

public interface EducationDAO {

	public void addEducation(Education education);

	public void deleteEducation(int eduId);

	public List<Education> listEducations();

	public List<Education> listEducationByUser(int userId);

	public Education updateEducation(Education education);

	public Education getEducation(int eduId);

}
