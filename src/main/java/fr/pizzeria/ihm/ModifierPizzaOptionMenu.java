package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu{
	Pizza pizza;
	
	public ModifierPizzaOptionMenu(IPizzaDao pizzaDao){
		super(pizzaDao);

		this.libelle="3. Modifier Pizza";	
	}
	
	@Override
	public boolean execute() { //L'utilisateur rentre de code de la pizza à supprimer
		System.out.println("Selectionner le code de la pizza � modifier... ");
		Scanner scan4=new Scanner(System.in); 
		String codePizza = scan4.nextLine();
		
		System.out.println("Veuillez saisir le nouveau code");
		Scanner scan1=new Scanner(System.in); 
		String nouveauCode= scan1.nextLine();
		System.out.println("Veuillez saisir le nouveau nom");
		Scanner scan2=new Scanner(System.in);
		String nouveauNom= scan2.nextLine();
		System.out.println("Veuillez saisir le nouveau prix");
		Scanner scan3=new Scanner(System.in);
		double nouveauPrix= scan3.nextDouble();
		
		Pizza nouvellePizza = new Pizza(nouveauCode,nouveauNom,nouveauPrix,CategoriePizza.SANS_VIANDE);
		
		try {
			this.pizzaDao.updatePizza(codePizza, nouvellePizza);
		} catch (UpdatePizzaException e) {
			e.printStackTrace();
		}
		return true;
	}
}
