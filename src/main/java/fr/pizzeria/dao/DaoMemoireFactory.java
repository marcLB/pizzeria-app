package fr.pizzeria.dao;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImplTableau;

public class DaoMemoireFactory implements DaoFactory{

	private IPizzaDao pizzaDao = new PizzaDaoImplTableau();
	
	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

}
