package com.fuseIn.connector;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

public class Cassandra {
	private Cluster cluster;	//cassandra cluster
	
	private Session session;	//cassandra session
	public void connectDb(String node, int portNumber) throws Exception {
		
		//https://docs.datastax.com/en/drivers/java/2.1/com/datastax/driver/core/Cluster.Builder.html#addContactPoint-java.lang.String-
		this.cluster = Cluster.builder().addContactPoint(node).withPort(portNumber).build();
		
		Metadata metadata = cluster.getMetadata();
		System.out.printf("Connected to cluster: %s\n", metadata.getClusterName());
		
		for(Host host : metadata.getAllHosts())
		{
			System.out.printf("Datacenter: %s; Host: %s; Rack: %s\n", host.getDatacenter(), host.getRack());
		}
		session = cluster.connect(); 
	}
	
	public Session getSession() {
		return this.session;
	}
	
	public void closeSession() {
		cluster.close();
	}
}
