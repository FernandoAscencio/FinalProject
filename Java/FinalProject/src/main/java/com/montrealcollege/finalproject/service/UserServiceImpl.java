package com.montrealcollege.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.montrealcollege.finalproject.dao.UserDAO;
import com.montrealcollege.finalproject.dao.UserImpl;
import com.montrealcollege.finalproject.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO udao;
	
	@Override
	@Transactional
	public void addUser(User user) {
		udao.addUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		udao.deleteUser(userId);
	}

	@Override
	@Transactional
	public List<User> listUser() {
		return udao.listUser();
	}

	@Override
	public User updateUser(User user) {
		return udao.updateUser(user);
	}

	@Override
	public User getUser(int userId) {
		return udao.getUser(userId);
	}
	
	public void setUserDAO (UserImpl dao) {
		this.udao = dao;
	}

}
