package fr.pizzeria.exception;

import fr.pizzeria.model.Pizza;

public interface Stockage {

	Pizza[] findAllPizzas();
	
	void saveNewPizza(Pizza pizza) throws SavePizzaException;
	
	void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
	
	void deletePizza(String codePizza) throws DeletePizzaException;

}