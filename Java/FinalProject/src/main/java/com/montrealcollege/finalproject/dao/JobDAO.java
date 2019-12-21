package com.montrealcollege.finalproject.dao;

import java.util.List;

import com.montrealcollege.finalproject.model.Job;

public interface JobDAO {

	public void addJob(Job job);

	public void deleteJob(int jobId);

	public List<Job> listJob();

	public List<Job> listJobByUser(int userId);

	public Job updateJob(Job job);

	public Job getJob(int jobId);
}
