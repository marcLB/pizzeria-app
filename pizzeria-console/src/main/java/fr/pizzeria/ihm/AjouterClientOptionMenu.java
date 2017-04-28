package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

public class AjouterClientOptionMenu extends OptionMenu {

	public AjouterClientOptionMenu(IPizzaDao pizzaDao) {
		super(pizzaDao);
		libelle="6. Ajouter un nouveau client";	
	}

	@Override
	public boolean execute() {
		
		System.out.println("********Ajout d'un nouveau client***********");
		System.out.println("Veuillez saisir le prenom");
		Scanner scan1=new Scanner(System.in); 
		String prenom = scan1.nextLine();
		System.out.println("Veuillez saisir le nom");
		Scanner scan2=new Scanner(System.in);
		String nom = scan2.nextLine();
		System.out.println("Veuillez saisir le solde client");
		Scanner scan3=new Scanner(System.in);
		double solde= scan3.nextDouble();
		
		//Client nouveauClient=new Client(pizzaDao.findAllClients().size(),nom,prenom);
		
		//this.pizzaDao.saveNewClient(nouveauClient);
		
		return false;
	}
}
