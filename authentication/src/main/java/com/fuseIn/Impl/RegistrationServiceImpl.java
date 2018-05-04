package com.fuseIn.Impl;

import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuseIn.Iservice.IRegister;
import com.fuseIn.Iservice.IRegisterDao;
import com.fuseIn.bo.RegisterBO;
import com.fuseIn.dao.RegisterDAO;
import com.fuseIn.util.EncodeCredentials;
/*
 * 
 * @author AshishChaturvedi
 * 
 */

@Service
public class RegistrationServiceImpl implements IRegister {

	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	private IRegisterDao registerUserDao;

	public String create(RegisterBO userBo) {
		JSONObject encryptedPass = null;
		
		RegisterDAO userDao = new RegisterDAO();

		userDao.setFirstName(userBo.getFirstName());
		userDao.setLastName(userBo.getLastName());
		userDao.setAddress(userBo.getAddress());
		userDao.setAge(userBo.getAge());
		userDao.setEmail(userBo.getEmail());
		userDao.setContact(userBo.getContact());
		userDao.setGender(userBo.getGender());
		userDao.setInterest(userBo.getInterest());
		
		try{
			encryptedPass = new EncodeCredentials().encodePassword(userBo.getPassword());
		}catch(NoSuchAlgorithmException exception) {
			logger.error(exception.getMessage());
		}
		
		String check = registerUserDao.create(userDao, encryptedPass);
		
		return check;
	}

	public IRegisterDao getRegisterUserDao() {
		return registerUserDao;
	}

	public void setRegisterUserDao(IRegisterDao registerUserDao) {
		this.registerUserDao = registerUserDao;
	}

}
