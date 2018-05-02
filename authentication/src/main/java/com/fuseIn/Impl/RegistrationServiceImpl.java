package com.fuseIn.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiseIn.bo.RegisterUserBO;
import com.fuseIn.Iservice.IRegister;
import com.fuseIn.Iservice.IRegisterDao;
import com.fuseIn.dao.RegisterUserDAO;

@Service
public class RegistrationServiceImpl implements IRegister{
	
	@Autowired
	private IRegisterDao registerUserDao;

	public void create(RegisterUserBO userBo) {
		
		RegisterUserDAO userDao = new RegisterUserDAO();
		
		userDao.setFirstName(userBo.getFirstName());
		userDao.setLastName(userBo.getLastName());
		userDao.setAddress(userBo.getAddress());
		userDao.setAge(userBo.getAge());
		userDao.setEmail(userBo.getEmail());
		userDao.setContact(userBo.getContact());
		userDao.setGender(userBo.getGender());
		userDao.setInterest(userBo.getInterest());
		
		System.out.println("Service: " +userBo.getFirstName());
		registerUserDao.create(userDao);
	}
	
	public IRegisterDao getRegisterUserDao() {
		return registerUserDao;
	}

	public void setRegisterUserDao(IRegisterDao registerUserDao) {
		this.registerUserDao = registerUserDao;
	}

}
