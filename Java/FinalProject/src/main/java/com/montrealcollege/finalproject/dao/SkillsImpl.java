package com.montrealcollege.finalproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montrealcollege.finalproject.model.Skills;

@Repository
public class SkillsImpl implements SkillsDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public void addSkills(Skills skills) {
		sf.getCurrentSession().saveOrUpdate(skills);
	}

	@Override
	public void deleteSkills(int skillsId) {
		Skills skills = (Skills) sf.getCurrentSession().load(Skills.class, skillsId);
		if (null != skills)
			sf.getCurrentSession().delete(skills);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Skills> listSkills() {
		return sf.getCurrentSession().createQuery("from Skills").list();
	}

	@Override
	public Skills listSkillsByUser(int userId) {
		Skills skills = (Skills) sf.getCurrentSession()
				.createQuery("from Skills E where E.user.id = " + userId).uniqueResult();
		return skills;
	}

	@Override
	public Skills updateSkills(Skills skills) {
		sf.getCurrentSession().update(skills);
		return skills;
	}

	@Override
	public Skills getSkills(int skillsId) {
		return (Skills) sf.getCurrentSession().get(Skills.class, skillsId);
	}

}
