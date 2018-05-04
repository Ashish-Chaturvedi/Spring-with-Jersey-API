package com.fuseIn.util;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String providedPassword = "password@123";
        
        // Encrypted and Base64 encoded password read from database
        String securePassword = "vysIcrhnt7w6246zMyd9H6JGIr+8s1Za3Qc6zkLl6vg=";
        
        // Salt value stored in database 
        String salt = "BxNW2lzCNCZG1fDklMqRf9MDoluyPL";
        
        boolean passwordMatch = EncodeCredentials.verifyPasswordAuthenticity(providedPassword, securePassword, salt);
        
        if(passwordMatch) 
        {
            System.out.println("Provided user password " + providedPassword + " is correct.");
        } else {
            System.out.println("Provided password is incorrect");
        }
    }
	

}
