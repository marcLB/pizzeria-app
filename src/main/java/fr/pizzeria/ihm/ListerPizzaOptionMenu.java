package fr.pizzeria.ihm;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzaOptionMenu extends OptionMenu{
	
	//CONSTRUCT
	public ListerPizzaOptionMenu(IPizzaDao pizzaDao) {
		super(pizzaDao);
		this.libelle="1. Lister les pizzas";		
	}

	

	@Override
	public boolean execute() {
		this.pizzaDao.findAllPizzas();
		return true;
	}


}
