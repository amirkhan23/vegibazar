package com.vegibazar.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vegibazar.dao.entity.UserRoles;
import com.vegibazar.dao.impl.UserRolesApiImpl;

@Service
@Transactional
public class UserRolesService {

	@Autowired
	UserRolesApiImpl urai;

	public boolean setRole(UserRoles userRoles) {
		return urai.setRole(userRoles);

	}

	
	public boolean updateRole(UserRoles userRoles) {
		return urai.updateRole(userRoles);
		
		
	}
}
