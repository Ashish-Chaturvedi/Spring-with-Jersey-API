package com.fuseIn.daoImpl;

import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.fasterxml.jackson.core.JsonParser;
import com.fuseIn.Iservice.IRegisterDao;
import com.fuseIn.connector.Cassandra;
import com.fuseIn.dao.RegisterDAO;
/*
 * 
 * @author AshishChaturvedi
 * 
 */

@Repository
public class RegistrationDaoImpl implements IRegisterDao{
	private String check = "";
	ResultSet resSet = null;
	
	public String create(RegisterDAO userDao) {
		boolean status = false;
		try {
			//Cassandra cassandraConn = new Cassandra();
		//	Session session = cassandraConn.getSession();
			// resSet = session.execute("insert into ");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	//status= resSet.wasApplied();
	//JSONObject jsonGenerated = new JSONObject(check);
	if (status = true) 
		check = "User registered Sucessfully";
	return check;
	}

	public String create(RegisterDAO text, JSONObject encryptedPass) {
		// TODO Auto-generated method stub
		return null;
	}
}
