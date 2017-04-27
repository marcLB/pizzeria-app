package fr.pizzeria.dao.fichier;

import fr.pizzeria.dao.pizza.DaoFactory;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.fichier.PizzaDaoImplFichier;

public class DaoFichierFactory implements DaoFactory{

	private static final String DATA_DIR = "../data/";
	private IPizzaDao pizzaDao = new PizzaDaoImplFichier();
	
	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

	public static String getDataDir() {
		return DATA_DIR;
	}
}