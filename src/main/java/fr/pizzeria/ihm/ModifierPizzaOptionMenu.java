package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu{

	public ModifierPizzaOptionMenu(IPizzaDao pizzaDao){
		super(pizzaDao);

		this.libelle="3. Modifier Pizza";	
	}
	
	@Override
	public boolean execute() { //L'utilisateur rentre de code de la pizza � supprimer
		Pizza nouvellePizza = null;
		
		System.out.println("Selectionner le code de la pizza � modifier... ");
		Scanner scan4=new Scanner(System.in); 
		String codePizza = scan4.nextLine();
		
		try {
			this.pizzaDao.updatePizza(codePizza, nouvellePizza);
		} catch (UpdatePizzaException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
