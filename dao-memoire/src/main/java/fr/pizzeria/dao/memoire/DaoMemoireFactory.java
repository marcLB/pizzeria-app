package fr.pizzeria.dao.memoire;

import fr.pizzeria.dao.pizza.DaoFactory;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.memoire.PizzaDaoImplTableau;

public class DaoMemoireFactory implements DaoFactory{

	private IPizzaDao pizzaDao = new PizzaDaoImplTableau();
	
	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

}
