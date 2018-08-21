package com.vegibazar.dao.api;

import java.util.List;

import com.vegibazar.dao.entity.User;

public interface UserAPI {
	
	public List<User> getAllUser();
	public boolean insertUser(User user);
	public boolean updateUserById(User user);
	public boolean deleteUserById(User user);
	public User getUserById(int userId); 
	public User getUserByEmail(String email);

}
