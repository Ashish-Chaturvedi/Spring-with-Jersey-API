package com.fuseIn.Impl;

import com.fuseIn.Iservice.IRegisterDao;
import com.fuseIn.dao.RegisterUserDAO;

public class RegistrationDAOImpl implements IRegisterDao{

	public void create(RegisterUserDAO userDao) {
		
		System.out.println("DAO: " + userDao.getFirstName());
	}
}