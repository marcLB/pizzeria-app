package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.model.Client;


public class ListerClientOptionMenu extends OptionMenu {

	public ListerClientOptionMenu(IPizzaDao pizzaDao) {
		super(pizzaDao);
		this.libelle="5. Lister les clients";
	}

	@Override
	public boolean execute() {
		List<Client> listeClient=this.pizzaDao.findAllClients();
		
		for(int i=0;i<listeClient.size();i++){
			System.out.println(listeClient.get(i).toString());
		}
		return false;
	}
}
