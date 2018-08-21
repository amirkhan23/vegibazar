package com.vegibazar.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vegibazar.dao.entity.Users;
import com.vegibazar.dao.impl.UsersApiImpl;

@Service
@Transactional
public class UsersService {

	@Autowired
	UsersApiImpl usai;
	
	public boolean addToUsers(Users users) {
		return usai.addToUsers(users);
		
		
	}
	
	public boolean updateToUsers(Users users) {
		return usai.addToUsers(users);
		
	}
	
}
