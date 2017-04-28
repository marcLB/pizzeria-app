package fr.pizzeria.console.client;

import java.util.ResourceBundle;
import java.util.logging.Level;

import javax.persistence.Persistence;

import fr.pizzeria.console.client.ihm.MenuLogin;
import fr.pizzeria.dao.pizza.DaoFactory;


public class PizzeriaClientConsoleApp {
    public static void main( String[] args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
    	
    	java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		Persistence.createEntityManagerFactory("pizzeria-unit");

    	
    	ResourceBundle bundle = ResourceBundle.getBundle("application");
    	String valueDaoFactory= bundle.getString("dao.impl");
		
    	Class<?> classDao = Class.forName(valueDaoFactory);
		
		DaoFactory daoFactory= (DaoFactory) classDao.newInstance();
    	
    	MenuLogin menu = new MenuLogin(daoFactory.getPizzaDao());
		menu.choixUtilisateur(); //Gestion de la réponse utilisateur
    }
}
