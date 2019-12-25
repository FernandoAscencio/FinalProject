package com.montrealcollege.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.montrealcollege.finalproject.dao.JobDAO;
import com.montrealcollege.finalproject.dao.JobImpl;
import com.montrealcollege.finalproject.model.Job;

@Service
@Transactional
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDAO jdao;
	
	@Override
	@Transactional
	public void addJob(Job job) {
		jdao.addJob(job);
	}

	@Override
	@Transactional
	public void deleteJob(int jobId) {
		jdao.deleteJob(jobId);
	}

	@Override
	@Transactional
	public List<Job> listJob() {
		return jdao.listJob();
	}

	@Override
	@Transactional
	public List<Job> listJobByUser(int userId) {
		return jdao.listJobByUser(userId);
	}

	@Override
	public Job updateJob(Job job) {
		return jdao.updateJob(job);
	}

	@Override
	public Job getJob(int jobId) {
		return jdao.getJob(jobId);
	}
	
	public void setJobDAO(JobImpl dao) {
		this.jdao = dao;
	}
}
