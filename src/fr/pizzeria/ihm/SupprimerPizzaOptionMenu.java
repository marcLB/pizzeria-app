package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu{

	public SupprimerPizzaOptionMenu(IPizzaDao pizzaDao){
		super(pizzaDao);

		this.libelle="4. Supprimer Pizza";	
	}
	
	@Override
	public boolean execute() { //L'utilisateur rentre de code de la pizza � modifier
		System.out.println("Selectionner le code de la pizza � supprimer... ");
		Scanner scan4=new Scanner(System.in); 
		String codePizza = scan4.nextLine();
		
		try {
			this.pizzaDao.deletePizza(codePizza);
			return true;
		} catch (DeletePizzaException e) {
			e.printStackTrace();
			return false;
		}
	}
}
