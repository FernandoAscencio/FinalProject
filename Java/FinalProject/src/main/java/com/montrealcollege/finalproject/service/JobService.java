package com.montrealcollege.finalproject.service;

import java.util.List;

import com.montrealcollege.finalproject.model.Job;

public interface JobService {

	public void addJob(Job job);

	public void deleteJob(int jobId);

	public List<Job> listJob();

	public List<Job> listJobByUser(int userId);

	public Job updateJob(Job job);

	public Job getJob(int jobId);
}
