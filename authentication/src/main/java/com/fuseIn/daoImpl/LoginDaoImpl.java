package com.fuseIn.daoImpl;

import org.springframework.stereotype.Repository;

import com.fuseIn.Iservice.ILoginDao;
import com.fuseIn.dao.LoginDAO;

@Repository
public class LoginDaoImpl implements ILoginDao{

	public void create(LoginDAO userDao) {
		
		//System.out.println("DAO: " + userDao.getEmail());
		
	}

}
