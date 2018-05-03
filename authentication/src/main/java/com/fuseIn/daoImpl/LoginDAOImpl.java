package com.fuseIn.daoImpl;

import org.springframework.stereotype.Repository;

import com.fuseIn.Iservice.ILoginDAO;
import com.fuseIn.dao.LoginUserDAO;

@Repository
public class LoginDAOImpl implements ILoginDAO{

	public void create(LoginUserDAO userDao) {
		
		//System.out.println("DAO: " + userDao.getEmail());
		
	}

}
