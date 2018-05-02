package com.fuseIn.Impl;

import com.fuseIn.Iservice.ILoginDAO;
import com.fuseIn.dao.LoginUserDAO;

public class LoginDAOImpl implements ILoginDAO{

	public void create(LoginUserDAO userDao) {
		
		System.out.println("DAO: " + userDao.getEmail());
		
	}

}
