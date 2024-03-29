package com.montrealcollege.finalproject.service;

import java.util.List;

import com.montrealcollege.finalproject.model.Skills;

public interface SkillsService {

	public void addSkills(Skills skills);

	public void deleteSkills(int skillsId);

	public List<Skills> listSkills();

	public Skills listSkillsByUser(int userId);

	public Skills updateSkills(Skills skills);

	public Skills getSkills(int skillsId);
}
