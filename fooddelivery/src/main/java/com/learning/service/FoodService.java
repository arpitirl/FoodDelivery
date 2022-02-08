package com.learning.service;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import com.learning.dto.Food;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.InvalidIdLengthException;

public interface FoodService {
	
	public Food addFood(Food food);
	public String deleteFood(String id) throws IdNotFoundException;
	public String modifyFood(String id, Food food) throws IdNotFoundException;
	public Optional<Food> getFoodById(String id) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException;
	public Optional<List<Food>> getAllFood() throws NameNotFoundException, InvalidIdLengthException;
	public Optional<Food> getFoodByFoodType(String foodType) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException;
	
}
