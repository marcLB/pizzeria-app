package fr.pizzeria.console;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.DaoFichierFactory;
import fr.pizzeria.dao.DaoMemoireFactory;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImplTableau;
import fr.pizzeria.dao.pizza.PizzaDaoImplFichier;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	
	
	public static void main(String[] args) {
		
		DaoFactory daoFactory = new DaoFichierFactory();
		
//		PizzaDaoImplFichier pizzaDaoImplFichier= new PizzaDaoImplFichier("data");
//		List<Pizza> listePizza = pizzaDaoImplFichier.findAllPizzas();
//		IPizzaDao pizzaDao=new PizzaDaoImplTableau();
	
		Menu menu = new Menu(daoFactory.getPizzaDao());
		menu.choixUtilisateur(); //Gestion de la réponse utilisateur 
	} 
}









