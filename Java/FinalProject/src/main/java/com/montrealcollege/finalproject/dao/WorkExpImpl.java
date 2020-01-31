package com.montrealcollege.finalproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montrealcollege.finalproject.model.WorkExperience;

@Repository
public class WorkExpImpl implements WorkExpDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public void addWorkExperience(WorkExperience we) {
		sf.getCurrentSession().saveOrUpdate(we);
	}

	@Override
	public void deleteWorkExperience(int weId) {
		WorkExperience we = (WorkExperience) sf.getCurrentSession().load(WorkExperience.class, weId);
		if (null != we)
			sf.getCurrentSession().delete(we);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkExperience> listWorkExperience() {
		return sf.getCurrentSession().createQuery("from WorkExperience").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkExperience> listWorkExperienceByUser(int userId) {
		List<WorkExperience> wes = (List<WorkExperience>) sf.getCurrentSession()
				.createQuery("from WorkExperience E where E.user.id = " + userId).list();
		return wes;
	}

	@Override
	public WorkExperience updateWorkExperience(WorkExperience we) {
		sf.getCurrentSession().update(we);
		return we;
	}

	@Override
	public WorkExperience getWorkExperience(int weId) {
		return (WorkExperience) sf.getCurrentSession().get(WorkExperience.class, weId);
	}

}
