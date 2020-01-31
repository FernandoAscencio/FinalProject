package com.montrealcollege.finalproject.service;

import java.util.List;

import com.montrealcollege.finalproject.model.Application;

public interface AppService {
	
	public void addApplication(Application app);
	
	public void deleteApplication(int appId);
	
	public List<Application> listApplications();
	
	public Application updateApplication(Application app);
	
	public Application getApplication(int appId);
	
	public List<Application> getAppByUser(int userId);
	
	public List<Application> getAppByJob(int jobId);

	Application getAppByUserJob(int userId, int jobId);
}
