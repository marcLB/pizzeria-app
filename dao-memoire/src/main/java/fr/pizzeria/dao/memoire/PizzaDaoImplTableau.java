package fr.pizzeria.dao.memoire;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTableau implements IPizzaDao{
	
	protected List<Pizza> listePizza= new ArrayList<Pizza>();
	protected List<Client> listeClient= new ArrayList<Client>();
	//CONSTRUCT 
	public PizzaDaoImplTableau() {
		super();
		listePizza.add(new Pizza("PEP","Pépéroni",12.50,CategoriePizza.VIANDE));
		listePizza.add(new Pizza("MAR","Margherita",14.00,CategoriePizza.VIANDE));
		listePizza.add(new Pizza("REI","La Reine",11.50,CategoriePizza.VIANDE));
		listePizza.add(new Pizza("FRO","La 4 Fromages",12.00,CategoriePizza.SANS_VIANDE));
		listePizza.add(new Pizza("CAN","La cannibale",12.50,CategoriePizza.VIANDE));
		listePizza.add(new Pizza("SAV","La savoyarde",13.00,CategoriePizza.VIANDE));
		listePizza.add(new Pizza("ORI","L'orientale",13.50,CategoriePizza.VIANDE));
		listePizza.add(new Pizza("IND","L'indienne",14.00,CategoriePizza.VIANDE));

		listeClient.add(new Client(0,"LE BOULCH","Marc",800));
		listeClient.add(new Client(1,"LAVAUD","Franc",2));
	}
	
	
	
	//METHODES
	@Override
	public List<Pizza> findAllPizzas() {	
		return listePizza;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException{
		
		int index=findPizzaWithCode(pizza.getCode());
		if(index>=0){
			throw new SavePizzaException("Code pizza déjà dans le menu..");
		}
		
		listePizza.add(pizza);
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException{
		
		int index=findPizzaWithCode(codePizza);
		
		if(index==-1){
			throw new UpdatePizzaException("Code non trouvé..");
		}
		
		listePizza.set(index,pizza);
		
		return true;
		
	}
	
	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {//Supprime la pizza donc le code correspond � l'argument
		int index=findPizzaWithCode(codePizza);
		
		if(index==-1){
			throw new DeletePizzaException("Code non trouvé..");
		}	
		listePizza.remove(index);		
		return true;
	}
	
	private int findPizzaWithCode(String codePizza){//Retourne l'id de la pizza correspondante au code 
		for(int i=0;i<listePizza.size();i++){
			if(listePizza.get(i).getCode().equals(codePizza)){
				return i;
			}
		}
		return -1;
	}

 	@Override
 	public List<Client> findAllClients() {
 		return listeClient;
 	}
 	
 	@Override
 	public boolean saveNewClient(Client client) {
 		listeClient.add(client);
 		return false;
 	}
	
 	@Override
	public void importData() {
		System.err.println("! Veuillez configurer l’application avec une implémentation base de données !");
	}
	
 	//GETTERS SETTERS
	public List<Pizza> getListePizza() {
		return listePizza;
	}
	public void setListePizza(List<Pizza> listePizza) {
		this.listePizza = listePizza;
	}



	


}
