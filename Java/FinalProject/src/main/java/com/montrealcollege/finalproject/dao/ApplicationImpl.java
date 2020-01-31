package com.montrealcollege.finalproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montrealcollege.finalproject.model.Application;

@Repository
public class ApplicationImpl implements ApplicationDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public void addApplication(Application app) {
		sf.getCurrentSession().saveOrUpdate(app);
	}

	@Override
	public void deleteApplication(int appId) {
		Application app = (Application) sf.getCurrentSession().load(Application.class, appId);
		if (null != app)
			sf.getCurrentSession().delete(app);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Application> listApplications() {
		return sf.getCurrentSession().createQuery("from Application").list();
	}

	@Override
	public Application updateApplication(Application app) {
		sf.getCurrentSession().update(app);
		return app;
	}

	@Override
	public Application getApplication(int appId) {
		return (Application) sf.getCurrentSession().get(Application.class, appId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Application> getAppByUser(int userId) {
		return (List<Application>) sf.getCurrentSession().createQuery("from Application A where A.user.id = " + userId)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Application> getAppByJob(int jobId) {
		return (List<Application>) sf.getCurrentSession().createQuery("from Application A where A.job.id = " + jobId)
				.list();
	}

	@Override
	public Application getAppByUserJob(int userId, int jobId) {
		String sql = "from Application A where A.user.id = "+userId+" and A.job.id = "+jobId;
		return (Application) sf.getCurrentSession().createQuery(sql).uniqueResult();
	}
}
