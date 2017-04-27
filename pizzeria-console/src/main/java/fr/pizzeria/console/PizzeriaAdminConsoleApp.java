package fr.pizzeria.console;

import fr.pizzeria.dao.pizza.DaoFactory;
import fr.pizzeria.ihm.Menu;
import java.util.ResourceBundle;
import com.github.lalyos.jfiglet.FigletFont;

public class PizzeriaAdminConsoleApp {
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
			
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String valueDaoFactory= bundle.getString("dao.impl");
		
		String asciiArt1 = FigletFont.convertOneLine("-- Pizzeria App --");
		System.out.println(asciiArt1);
		
		Class<?> classDao = Class.forName(valueDaoFactory);
		
		DaoFactory daoFactory= (DaoFactory) classDao.newInstance(); 
		
		Menu menu = new Menu(daoFactory.getPizzaDao());
		menu.choixUtilisateur(); //Gestion de la réponse utilisateur 
	}
}








