package com.fuseIn.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.fuseIn.Iservice.ILogin;
import com.fuseIn.Iservice.ILoginDAO;
import com.fuseIn.bo.LoginUserBO;
import com.fuseIn.dao.LoginUserDAO;

public class LoginServiceImpl implements ILogin{
	
	@Autowired
	private ILoginDAO loginUserDao;

	public void create(LoginUserBO userBo) {
		
		LoginUserDAO userDao = new LoginUserDAO();
		
		userDao.setEmail(userBo.getEmail());
		userDao.setPassword(userBo.getPassword());
		
		loginUserDao.create(userDao);
	}
	
	public ILoginDAO getLoginUserDao() {
		return loginUserDao;
	}

	public void setRegisterUserDao(ILoginDAO loginUserDao) {
		this.loginUserDao = loginUserDao;
	}
}
