package com.vegibazar.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vegibazar.dao.entity.User;
import com.vegibazar.dao.impl.UserApiImpl;

@Service
@Transactional
public class UserService {

	@Autowired
	UserApiImpl uai;

	public List<User> getAllUser() {
		return uai.getAllUser();

	}

	public boolean insertUser(User user) {
		return uai.insertUser(user);

	}

	public boolean updateUserById(User user) {
		return uai.updateUserById(user);

	}

	public boolean deleteUserById(User user) {
		return uai.deleteUserById(user);

	}

	public User getUserById(int userId) {
		return uai.getUserById(userId);

	}

	public User getUserByEmail(String email) {
		return uai.getUserByEmail(email);

	};

}
