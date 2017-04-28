package fr.pizzeria.console.client.ihm;

import fr.pizzeria.dao.pizza.IPizzaDao;

public class ConnexionClientOptionMenu extends OptionMenu {

	public ConnexionClientOptionMenu(IPizzaDao pizzaDao) {
		super(pizzaDao);
		this.libelle="2. Se connecter";
	}

	@Override
	public boolean execute() {
		return false;
	}

}
