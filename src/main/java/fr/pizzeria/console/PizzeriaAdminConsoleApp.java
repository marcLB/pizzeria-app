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
import com.github.lalyos.jfiglet.FigletFont;

public class PizzeriaAdminConsoleApp {
	
	
	public static void main(String[] args) {
		String asciiArt = FigletFont.convertOneLine("-------------------");
		String asciiArt1 = FigletFont.convertOneLine("-- Pizzeria App --");
		String asciiArt2 = FigletFont.convertOneLine("-------------------");
		//System.out.println(asciiArt);
		System.out.println(asciiArt1);
		//System.out.println(asciiArt2);
		
		
		DaoFactory daoFactoryFichier = new DaoFichierFactory();
		DaoFactory daoFactoryMemoire = new DaoMemoireFactory();
		
		
//		PizzaDaoImplFichier pizzaDaoImplFichier= new PizzaDaoImplFichier("data");
//		List<Pizza> listePizza = pizzaDaoImplFichier.findAllPizzas();
//		IPizzaDao pizzaDao=new PizzaDaoImplTableau();
	
		Menu menu = new Menu(daoFactoryFichier.getPizzaDao());
		menu.choixUtilisateur(); //Gestion de la réponse utilisateur 
	}
}








