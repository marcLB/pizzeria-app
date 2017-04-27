package fr.pizzeria.dao.jdbc;

import fr.pizzeria.dao.pizza.DaoFactory;
import fr.pizzeria.dao.pizza.IPizzaDao;

public class DaoJDBCFactory implements DaoFactory{
	
	private IPizzaDao pizzaDao = new PizzaDaoImplJDBC();
	
	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}
}
