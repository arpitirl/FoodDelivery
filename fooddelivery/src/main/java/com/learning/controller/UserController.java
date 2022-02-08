package com.learning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.service.UserService;

@RestController 
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/addUser")
	
	public ResponseEntity<?> addUser(@Valid @RequestBody Register register) throws AlreadyExistsException {
		
		
		Register result = userService.addUser(register);
		return ResponseEntity.status(201).body(result);
		
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") String id) throws IdNotFoundException{
		Register result = userService.getUserById(id);
		return ResponseEntity.ok(result);	
		
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllUserDetails(){
		Optional<List<Register>> optional = userService.getAllUserDetails();
		if(optional.isEmpty()) {
			Map<String, String> map = new HashMap<>();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());	
		
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") String id) throws IdNotFoundException{
		String result = userService.deleteUserById(id);
		return ResponseEntity.ok(result);	
		
	}
	
	
	@PutMapping("/{email}")
	public ResponseEntity<?> updateUser(@PathVariable("email") String email, @Valid @RequestBody Register register) throws IdNotFoundException{
		String result = userService.updateUser(email,register);
		return ResponseEntity.ok(result);	
		
	}
	
	

}
