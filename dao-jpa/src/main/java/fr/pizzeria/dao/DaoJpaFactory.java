package fr.pizzeria.dao;

import fr.pizzeria.dao.pizza.DaoFactory;
import fr.pizzeria.dao.pizza.IPizzaDao;

public class DaoJpaFactory implements DaoFactory{
	
	private IPizzaDao pizzaDao = new PizzaDaoImplJpa();

	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

}
