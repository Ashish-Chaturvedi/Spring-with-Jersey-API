package com.fuseIn.Iservice;

import org.json.JSONObject;

import com.fuseIn.dao.RegisterDAO;
/*
 * 
 * @author AshishChaturvedi
 * 
 */
public interface IRegisterDao {
	public String create(RegisterDAO text, JSONObject encryptedPass);
}
