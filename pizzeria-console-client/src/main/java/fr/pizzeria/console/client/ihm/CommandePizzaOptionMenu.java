package fr.pizzeria.console.client.ihm;

import fr.pizzeria.dao.pizza.IPizzaDao;

public class CommandePizzaOptionMenu extends OptionMenu {

	public CommandePizzaOptionMenu(IPizzaDao pizzaDao) {
		super(pizzaDao);
		this.libelle="1. Commander une pizza";
	}

	@Override
	public boolean execute() {
		
		
		
		
		return false;
	}

}
