package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu{
	protected Pizza nouvellePizza;
	
	public NouvellePizzaOptionMenu(IPizzaDao pizzaDao){
		super(pizzaDao);
		libelle="2. Nouvelle pizza";	
	}
	
	
	@Override
	public boolean execute() {
		
		System.out.println("********Ajout d'une nouvelle pizza***********");
		System.out.println("Veuillez saisir le code");
		Scanner scan1=new Scanner(System.in); 
		String codePizza = scan1.nextLine();
		System.out.println("Veuillez saisir le nom");
		Scanner scan2=new Scanner(System.in);
		String nomPizza = scan2.nextLine();
		System.out.println("Veuillez saisir le prix");
		Scanner scan3=new Scanner(System.in);
		double prixPizza = scan3.nextDouble();
		
		nouvellePizza=new Pizza(codePizza,nomPizza,prixPizza,CategoriePizza.SANS_CATEGORIE);
		
		try {
			this.pizzaDao.saveNewPizza(nouvellePizza);
		} catch (SavePizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}


	public Pizza getNouvellePizza() {
		return nouvellePizza;
	}
	public void setNouvellePizza(Pizza nouvellePizza) {
		this.nouvellePizza = nouvellePizza;
	}

}
