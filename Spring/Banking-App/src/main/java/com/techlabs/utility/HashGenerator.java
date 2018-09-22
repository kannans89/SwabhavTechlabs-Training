package com.techlabs.utility;

import org.mindrot.jbcrypt.BCrypt;

public class HashGenerator {
	public String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public boolean checkPassword(String plain, String hash) {
		if(BCrypt.checkpw(plain, hash)) {
			System.out.println("Password match");
			return true;
		} else {
			System.out.println("Password do not match");
			return false;
		}
	}
}
