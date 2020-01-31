package com.montrealcollege.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.montrealcollege.finalproject.dao.ApplicationDAO;
import com.montrealcollege.finalproject.model.Application;

@Service
@Transactional
public class AppServiceImpl implements AppService {
	
	@Autowired
	private ApplicationDAO adao;
	
	@Override
	@Transactional
	public void addApplication(Application app) {
		adao.addApplication(app);
	}

	@Override
	@Transactional
	public void deleteApplication(int appId) {
		adao.deleteApplication(appId);
	}

	@Override
	@Transactional
	public List<Application> listApplications() {
		return adao.listApplications();
	}

	@Override
	public Application updateApplication(Application app) {
		return adao.updateApplication(app);
	}

	@Override
	public Application getApplication(int appId) {
		return adao.getApplication(appId);
	}

	@Override
	@Transactional
	public List<Application> getAppByUser(int userId) {
		return adao.getAppByUser(userId);
	}

	@Override
	@Transactional
	public List<Application> getAppByJob(int jobId) {
		return adao.getAppByJob(jobId);
	}
	
	@Override
	@Transactional
	public Application getAppByUserJob(int userId, int jobId) {
		return adao.getAppByUserJob(userId, jobId);
	}
	
	public void setApplicationDAO(ApplicationDAO adao) {
		this.adao = adao;
	}
}
