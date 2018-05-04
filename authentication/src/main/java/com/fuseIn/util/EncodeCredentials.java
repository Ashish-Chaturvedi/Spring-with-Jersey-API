package com.fuseIn.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.json.JSONObject;

import com.fuseIn.entity.HashFunctionModel;

public class EncodeCredentials {
	private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
   

	public JSONObject encodePassword(String password) throws NoSuchAlgorithmException {
 
        String salt = saltValueGenerator(30);
        
        String hashCodeGenerated = generateSecurePassword(password, salt);

        HashFunctionModel hashFunc = new HashFunctionModel();
        hashFunc.setSaltValue(salt);
        hashFunc.setEncryptedPass(hashCodeGenerated);
        
        JSONObject hashObj = new JSONObject(hashFunc);
        
	return hashObj;
	}
	
	 public static String saltValueGenerator(int length) {
	        StringBuilder returnValue = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
	            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
	        }
	        return new String(returnValue);
	    }
	    public static byte[] hash(char[] password, byte[] salt) {
	        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
	        Arrays.fill(password, Character.MIN_VALUE);
	        try {
	            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	            return skf.generateSecret(spec).getEncoded();
	        } catch (Exception e) {
	            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
	        } finally {
	            spec.clearPassword();
	        }
	    }
	    public static String generateSecurePassword(String password, String salt) {
	        String returnValue = null;
	        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
	 
	        returnValue = Base64.getEncoder().encodeToString(securePassword);
	 
	        return returnValue;
	    }
	    
	    public static boolean verifyPasswordAuthenticity(String providedPassword,
	            String securedPassword, String salt)
	    {
	        boolean returnValue = false;
	        
	        String newSecurePassword = generateSecurePassword(providedPassword, salt);
	        returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);
	        
	        return returnValue;
}
}
