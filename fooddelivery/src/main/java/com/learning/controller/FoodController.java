package com.learning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.validation.Valid;

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

import com.learning.dto.Food;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.InvalidIdLengthException;
import com.learning.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {
	
	@Autowired
	FoodService foodService;
	
	@PostMapping("/addFood")
	
	public ResponseEntity<?> addFood(@RequestBody Food food) {
		
		Food result = foodService.addFood(food);
		return ResponseEntity.status(201).body(result);
	}
	
	@GetMapping("food/{id}")
	public ResponseEntity<?> getFoodById(@PathVariable("id") String id) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException{
		Optional<Food> result = foodService.getFoodById(id);
		return ResponseEntity.ok(result);	
		
	}
	
	
		@GetMapping("/all")
		public ResponseEntity<?> getAllFood() throws NameNotFoundException, InvalidIdLengthException{
			Optional<List<Food>> optional = foodService.getAllFood();
			if(optional.isEmpty()) {
				Map<String, String> map = new HashMap<>();
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
			}
			return ResponseEntity.ok(optional.get());	
			
		}
		
		
		@GetMapping("foodtype/{foodType}")
		public ResponseEntity<?> getFoodByFoodType(@PathVariable("foodType") String foodType) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException{
			Optional<Food> result = foodService.getFoodByFoodType(foodType);
			return ResponseEntity.ok(result);	
			
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteUserById(@PathVariable("id") String id) throws IdNotFoundException{
			String result = foodService.deleteFood(id);
			return ResponseEntity.ok(result);	
			
		}
		@PutMapping("/update/{id}")
		public ResponseEntity<?> modifyFood(@PathVariable("id") String id, @Valid @RequestBody Food food) throws IdNotFoundException{
			String result = foodService.modifyFood(id,food);
			return ResponseEntity.ok(result);	
			
		}
	
}
