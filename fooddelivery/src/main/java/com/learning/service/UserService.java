package com.learning.service;

import java.util.Optional;

import com.learning.dto.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.InvalidEmailException;
import com.learning.exception.InvalidIdLengthException;
import com.learning.exception.InvalidNameException;
import com.learning.exception.InvalidPasswordException;
import com.learning.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


public interface UserService {
	public Register addUser(Register register) throws AlreadyExistsException;
	public String updateUser(String id, Register register) throws IdNotFoundException;
	public Register getUserById(String id) throws IdNotFoundException;
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException;
	public String deleteUserById(String id) throws IdNotFoundException;
	public Optional<List<Register>> getAllUserDetails();
}
