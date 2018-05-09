package com.fuseIn.daoImpl;

import org.json.JSONObject;
import org.springframework.stereotype.Repository;

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
public class RegistrationDaoImpl implements IRegisterDao {
	private String check = "";
	//ResultSet resSet = null;

	public String create(RegisterDAO userDao, JSONObject encryptedPass) {
		boolean status = false;
		String id="1234123121";
		try {
	Cassandra cassandraConn = new Cassandra();
		cassandraConn.connectDb("localhost");
			Session session = cassandraConn.getSession();
			/*resSet = session.execute(
					"insert into fusein.user(email,age,firstname,id,interest,lastname,password_hash,salt) values("
							+ userDao.getEmail(),
					userDao.getAge(), userDao.getFirstName(),id,userDao.getInterest(),
					userDao.getLastName(), encryptedPass.get("encryptedPass"),
					encryptedPass.get("saltValue") + ") IF NOT EXISTS;");*/
		} catch (Exception e) {
			e.printStackTrace();
		//status = resSet.wasApplied();
	//	JSONObject jsonGenerated = new JSONObject(check);
		
	}
		if (status = true)
			check = "User registered Sucessfully";
		return check;
}
}
