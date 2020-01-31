package com.montrealcollege.finalproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montrealcollege.finalproject.model.Education;

@Repository
public class EducationImpl implements EducationDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public void addEducation(Education education) {
		sf.getCurrentSession().saveOrUpdate(education);
	}

	@Override
	public void deleteEducation(int eduId) {
		Education edu = (Education) sf.getCurrentSession().load(Education.class, eduId);
		if (null != edu)
			sf.getCurrentSession().delete(edu);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Education> listEducations() {
		return sf.getCurrentSession().createQuery("from Education").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Education> listEducationByUser(int userId) {
		List<Education> edus = (List<Education>) sf.getCurrentSession()
				.createQuery("from Education E where E.user.id = " + userId).list();
		return edus;
	}

	@Override
	public Education updateEducation(Education education) {
		sf.getCurrentSession().update(education);
		return education;
	}

	@Override
	public Education getEducation(int eduId) {
		return (Education) sf.getCurrentSession().get(Education.class, eduId);
	}

}
