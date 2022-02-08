package com.learning.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.dto.Food;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.InvalidIdLengthException;
import com.learning.repository.FoodRepository;
import com.learning.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {


	@Autowired
	private FoodRepository repository ;
	
	@Override
	
	public Food addFood(Food food) {

		Food food2 = repository.save(food);
		if (food2 != null) {
			
			return food2;
		} else {
			return null;
		}
	}

	@Override
	public String deleteFood(String id) throws IdNotFoundException {
		
		
		Optional<Food> optional;
		try {
			optional = this.getFoodById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				repository.deleteById(id);
				return "foods record deleted";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | NameNotFoundException e) {
			
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public String modifyFood(String id, Food food) throws IdNotFoundException {
		
		if(!this.repository.existsById(id))
			throw new IdNotFoundException("invalid email");
		
		return (this.repository.save(food)!= null) ? "success":"fail";
	}

	@Override
	public Optional<Food> getFoodById(String id) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException {
		
		return repository.findById(id);
	}

	@Override
	public Optional<List<Food>> getAllFood() throws NameNotFoundException, InvalidIdLengthException {
		
		return Optional.ofNullable(repository.findAll());
	}

	@Override
	public Optional<Food> getFoodByFoodType(String foodType)
			throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException {
		
		return null;
	}
    

}
