package fr.pizzeria.dao.pizza;

import fr.pizzeria.dao.pizza.IPizzaDao;

public interface DaoFactory {
	IPizzaDao getPizzaDao();
}
