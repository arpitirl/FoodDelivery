package com.learning.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dto.FOODTYPE;
import com.learning.dto.Login;
import com.learning.exception.IdNotFoundException;
import com.learning.repository.LoginRepository;
import com.learning.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {


	@Autowired
	private LoginRepository repository ;
	
	@Override
	public String addCredentials(Login login) {
		
		Login login2 = repository.save(login);
		if (login2 != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	@Override
	public String deleteCredentials(String userName) {
		
		
		Optional<Login> optional;
		try {
			optional = repository.findById(userName);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				repository.deleteById(userName);
				return "login record deleted";
			}
		} catch (IdNotFoundException e) {
			
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String changePassword(String userName, String password) {
		
		return null;
	}

	@Override
	public String changeRole(String userName, FOODTYPE role) {
		
		return null;
	}

}
