package com.fuseIn.entity;

public class HashFunctionModel {

	
	private String saltValue;
	private String encryptedPass;
	
	public String getSaltValue() {
		return saltValue;
	}
	public void setSaltValue(String saltValue) {
		this.saltValue = saltValue;
	}
	public String getEncryptedPass() {
		return encryptedPass;
	}
	public void setEncryptedPass(String encryptedPass) {
		this.encryptedPass = encryptedPass;
	}
	
}
