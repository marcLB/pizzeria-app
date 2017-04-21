package fr.pizzeria.ihm;

import fr.pizzeria.dao.pizza.IPizzaDao;

public class ListerLivreurOptionMenu extends OptionMenu {

	public ListerLivreurOptionMenu(IPizzaDao pizzaDao) {
		super(pizzaDao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute() {
		this.pizzaDao.findAllClients();
		return false;
	}

}
