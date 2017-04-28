package fr.pizzeria.console.client.ihm;

import fr.pizzeria.dao.pizza.IPizzaDao;

public class ListerCommandeOptionMenu extends OptionMenu {

	public ListerCommandeOptionMenu(IPizzaDao pizzaDao) {
		super(pizzaDao);
		this.libelle="2. Lister les commandes";
	}

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		return false;
	}

}
