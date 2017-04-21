package fr.pizzeria.ihm;

import fr.pizzeria.dao.pizza.IPizzaDao;

public class CrediterClientOptionMenu extends OptionMenu {

	public CrediterClientOptionMenu(IPizzaDao pizzaDao) {
		super(pizzaDao);
		libelle="7. Créditer le compte d’un client";	
	}

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		return false;
	}

}
