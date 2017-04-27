package fr.pizzeria.ihm;

import fr.pizzeria.dao.pizza.IPizzaDao;

public class ImporterDonneesOptionMenu extends OptionMenu {

	public ImporterDonneesOptionMenu(IPizzaDao pizzaDao) {
		super(pizzaDao);
		this.libelle="8. Importer les données vers la BDD";
	}

	@Override
	public boolean execute() {
		this.pizzaDao.importData();
		return false;
	}

}
