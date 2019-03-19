package com.cg.pizza.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.pizza.beans.Pizza;

public interface PizzaDAO extends JpaRepository<Pizza, Integer>{
	
}
