package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.ihm.IPizzaDao;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	
	
	public static void main(String[] args) {
		
		IPizzaDao pizzaDao=new PizzaDaoImpl();
		
		Menu menu = new Menu(pizzaDao);
		menu.choixUtilisateur(); //Gestion de la réponse utilisateur 
	}
}









