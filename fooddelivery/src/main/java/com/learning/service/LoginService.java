package com.learning.service;

import com.learning.dto.FOODTYPE;
import com.learning.dto.Login;

public interface LoginService {
	public String addCredentials(Login login);
	public String deleteCredentials(String userName);
	public String changePassword(String userName, String password);
	public String changeRole(String userName, FOODTYPE role);
	

}
