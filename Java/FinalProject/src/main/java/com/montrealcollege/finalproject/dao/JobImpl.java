package com.montrealcollege.finalproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montrealcollege.finalproject.model.Job;

@Repository
public class JobImpl implements JobDAO {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public void addJob(Job job) {
		sf.getCurrentSession().saveOrUpdate(job);
	}

	@Override
	public void deleteJob(int jobId) {
		Job job = (Job) sf.getCurrentSession().load(Job.class, jobId);
		if (null!=job)
			sf.getCurrentSession().delete(job);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> listJob() {
		return sf.getCurrentSession().createQuery("from Job").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> listJobByUser(int userId) {
		List<Job> jobs = (List<Job>) sf.getCurrentSession().createQuery("from Job E where E.user.id = "+userId).list();
		return jobs;
	}

	@Override
	public Job updateJob(Job job) {
		sf.getCurrentSession().update(job);
		return job;
	}

	@Override
	public Job getJob(int jobId) {
		return (Job) sf.getCurrentSession().get(Job.class, jobId);
	}

}
