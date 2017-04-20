package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzaOptionMenu extends OptionMenu{
	
	//CONSTRUCT
	public ListerPizzaOptionMenu(IPizzaDao pizzaDao) {
		super(pizzaDao);
		this.libelle="1. Lister les pizzas";		
	}

	

	@Override
	public boolean execute() {
		List<Pizza> listePizza=this.pizzaDao.findAllPizzas();
		
		for(int i=0;i<listePizza.size();i++){
			listePizza.get(i).toString();
		}
		
		
		//System.out.println(listePizza.get(0).toString());
		return true;
	}


}
