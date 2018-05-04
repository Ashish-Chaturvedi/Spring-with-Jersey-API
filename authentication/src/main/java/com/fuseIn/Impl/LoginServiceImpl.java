package com.fuseIn.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuseIn.Iservice.ILogin;
import com.fuseIn.Iservice.ILoginDao;
import com.fuseIn.bo.LoginBO;
import com.fuseIn.dao.LoginDAO;

@Service
public class LoginServiceImpl implements ILogin{
	
	@Autowired
	private ILoginDao loginUserDao;

	public void create(LoginBO userBo) {
		
		LoginDAO userDao = new LoginDAO();
		
		userDao.setEmail(userBo.getEmail());
		userDao.setPassword(userBo.getPassword());
		
		loginUserDao.create(userDao);
	}

	public ILoginDao getLoginUserDao() {
		return loginUserDao;
	}

	public void setLoginUserDao(ILoginDao loginUserDao) {
		this.loginUserDao = loginUserDao;
	}

	
}
