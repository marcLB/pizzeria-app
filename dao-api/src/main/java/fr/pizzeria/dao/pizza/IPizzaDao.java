package fr.pizzeria.dao.pizza;

import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {

		List<Pizza> findAllPizzas();
		boolean saveNewPizza(Pizza pizza) throws SavePizzaException;
		boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
		boolean deletePizza(String codePizza) throws DeletePizzaException;
		
		List<Client> findAllClients();
		boolean saveNewClient(Client client);
		void importData();
		
}
