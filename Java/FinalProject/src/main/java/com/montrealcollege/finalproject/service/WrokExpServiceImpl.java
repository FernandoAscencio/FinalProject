package com.montrealcollege.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.montrealcollege.finalproject.dao.WorkExpDAO;
import com.montrealcollege.finalproject.dao.WorkExpImpl;
import com.montrealcollege.finalproject.model.WorkExperience;

@Service
@Transactional
public class WrokExpServiceImpl implements WorkExpericenceService {

	@Autowired
	private WorkExpDAO wedao;
	
	@Override
	@Transactional
	public void addWorkExperience(WorkExperience we) {
		wedao.addWorkExperience(we);
	}

	@Override
	@Transactional
	public void deleteWorkExperience(int weId) {
		wedao.deleteWorkExperience(weId);
	}

	@Override
	@Transactional
	public List<WorkExperience> listWorkExperience() {
		return wedao.listWorkExperience();
	}

	@Override
	@Transactional
	public List<WorkExperience> listWorkExperienceByUser(int userId) {
		return wedao.listWorkExperienceByUser(userId);
	}

	@Override
	public WorkExperience updateWorkExperience(WorkExperience we) {
		return wedao.updateWorkExperience(we);
	}

	@Override
	public WorkExperience getWorkExperience(int weId) {
		return wedao.getWorkExperience(weId);
	}
	
	public void setWorkExpDAO (WorkExpImpl dao) {
		this.wedao = dao;
	}
}
