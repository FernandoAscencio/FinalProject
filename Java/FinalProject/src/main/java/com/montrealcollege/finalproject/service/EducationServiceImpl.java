package com.montrealcollege.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.montrealcollege.finalproject.dao.EducationDAO;
import com.montrealcollege.finalproject.dao.EducationImpl;
import com.montrealcollege.finalproject.model.Education;

@Service
@Transactional
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationDAO edao;

	@Override
	@Transactional
	public void addEducation(Education education) {
		edao.addEducation(education);
	}

	@Override
	@Transactional
	public void deleteEducation(int eduId) {
		edao.deleteEducation(eduId);
	}

	@Override
	@Transactional
	public List<Education> listEducations() {
		return edao.listEducations();
	}

	@Override
	@Transactional
	public List<Education> listEducationByUser(int userId) {
		return edao.listEducationByUser(userId);
	}

	@Override
	public Education updateEducation(Education education) {
		return edao.updateEducation(education);
	}

	@Override
	public Education getEducation(int eduId) {
		return edao.getEducation(eduId);
	}

	public void setEducationDAO(EducationImpl dao) {
		this.edao = dao;
	}
}
