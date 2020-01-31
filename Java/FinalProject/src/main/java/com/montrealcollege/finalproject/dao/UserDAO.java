package com.montrealcollege.finalproject.dao;

import java.util.List;

import com.montrealcollege.finalproject.model.Login;
import com.montrealcollege.finalproject.model.User;

public interface UserDAO {

	public void addUser(User user);

	public void deleteUser(int userId);

	public List<User> listUser();

	public User updateUser(User user);

	public User getUser(int userId);

	public User validateUser(Login login);
}
