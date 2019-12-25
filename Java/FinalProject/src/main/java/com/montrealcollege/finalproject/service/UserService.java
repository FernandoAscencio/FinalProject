package com.montrealcollege.finalproject.service;

import java.util.List;

import com.montrealcollege.finalproject.model.User;

public interface UserService {
	
	public void addUser(User user);

	public void deleteUser(int userId);

	public List<User> listUser();

	public User updateUser(User user);

	public User getUser(int userId);
}
