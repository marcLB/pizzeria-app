package fr.pizzeria.console.client.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;

public class InscriptionClientOptionMenu extends OptionMenu {

	public InscriptionClientOptionMenu(IPizzaDao pizzaDao) {
		super(pizzaDao);
		this.libelle="1. S'inscrire";
	}

	@Override
	public boolean execute() {

		System.out.println("********Ajout d'un nouveau***********");
		System.out.println("Veuillez saisir votre Nom");
		Scanner scan1=new Scanner(System.in); 
		String nomClient = scan1.nextLine();
		
		System.out.println("Veuillez saisir votre Prenom");
		Scanner scan2=new Scanner(System.in);
		String prenomClient = scan2.nextLine();
		
		System.out.println("Veuillez saisir votre Email");
		Scanner scan3=new Scanner(System.in);
		String emailClient= scan3.nextLine();
		
		System.out.println("Veuillez saisir votre mot de passe");
		Scanner scan4=new Scanner(System.in);
		int mot_de_passe= scan4.nextInt();
		
		System.out.println("Veuillez confirmer votre mot de passe");
		Scanner scan5=new Scanner(System.in);
		int mot_de_passe2= scan4.nextInt();	
		
		if(mot_de_passe==mot_de_passe2){		
			Client nouveauClient=new Client(nomClient,prenomClient,emailClient,mot_de_passe);
			try{
				this.pizzaDao.saveNewClient(nouveauClient);
			}catch(SavePizzaException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
