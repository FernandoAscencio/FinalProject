package com.montrealcollege.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.montrealcollege.finalproject.dao.SkillsDAO;
import com.montrealcollege.finalproject.dao.SkillsImpl;
import com.montrealcollege.finalproject.model.Skills;

@Service
@Transactional
public class SkillsServiceImpl implements SkillsService {

	@Autowired
	private SkillsDAO sdao;
	
	@Override
	@Transactional
	public void addSkills(Skills skills) {
		sdao.addSkills(skills);
	}

	@Override
	@Transactional
	public void deleteSkills(int skillsId) {
		sdao.deleteSkills(skillsId);
	}

	@Override
	@Transactional
	public List<Skills> listSkills() {
		return sdao.listSkills();
	}

	@Override
	@Transactional
	public List<Skills> listSkillsByUser(int userId) {
		return sdao.listSkillsByUser(userId);
	}

	@Override
	public Skills updateSkills(Skills skills) {
		return sdao.updateSkills(skills);
	}

	@Override
	public Skills getSkills(int skillsId) {
		return sdao.getSkills(skillsId);
	}
	
	public void setSkillsDAO(SkillsImpl dao) {
		this.sdao = dao;
	}
}
