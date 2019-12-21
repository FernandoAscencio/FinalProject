package com.montrealcollege.finalproject.dao;

import java.util.List;

import com.montrealcollege.finalproject.model.Skills;

public interface SkillsDAO {
	
	public void addSkills(Skills skills);

	public void deleteSkills(int skillsId);

	public List<Skills> listSkills();

	public List<Skills> listSkillsByUser(int userId);

	public Skills updateSkills(Skills skills);

	public Skills getSkills(int skillsId);
}
