package com.montrealcollege.finalproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montrealcollege.finalproject.model.User;

@Repository
public class UserImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public void addUser(User user) {
		sf.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void deleteUser(int userId) {
		User user = (User) sf.getCurrentSession().load(User.class, userId);
		if (null!=user)
			sf.getCurrentSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUser() {
		return sf.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User updateUser(User user) {
		sf.getCurrentSession().update(user);
		return user;
	}

	@Override
	public User getUser(int userId) {
		return (User) sf.getCurrentSession().get(User.class, userId);
	}

}
