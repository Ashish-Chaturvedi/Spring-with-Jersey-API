package com.fuseIn.daoImpl;

import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Session;
import com.fuseIn.Iservice.IRegisterDao;
import com.fuseIn.connector.Cassandra;
import com.fuseIn.dao.RegisterUserDAO;
/*
 * 
 * @author AshishChaturvedi
 * 
 */

@Repository
public class RegistrationDAOImpl implements IRegisterDao{

	public void create(RegisterUserDAO userDao) {
		
	Cassandra cassandraConn = new Cassandra();
	Session session = cassandraConn.getSession();
		
	}
}
