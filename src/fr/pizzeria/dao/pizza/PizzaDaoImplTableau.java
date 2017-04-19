package fr.pizzeria.dao.pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTableau implements IPizzaDao{
	//Pizza[] listePizza=new Pizza[50];
	protected List<Pizza> listePizza= new ArrayList<Pizza>();
	//CONSTRUCT 
	public PizzaDaoImplTableau() {
		super();
		listePizza.add(new Pizza(0,"PEP","Pépéroni",12.50,CategoriePizza.VIANDE));
		listePizza.add(new Pizza(1,"MAR","Margherita",14.00,CategoriePizza.VIANDE));
		listePizza.add(new Pizza(2,"REI","La Reine",11.50,CategoriePizza.VIANDE));
		listePizza.add(new Pizza(3,"FRO","La 4 Fromages",12.00,CategoriePizza.SANS_VIANDE));
		listePizza.add(new Pizza(4,"CAN","La cannibale",12.50,CategoriePizza.VIANDE));
		listePizza.add(new Pizza(5,"SAV","La savoyarde",13.00,CategoriePizza.VIANDE));
		listePizza.add(new Pizza(6,"ORI","L'orientale",13.50,CategoriePizza.VIANDE));
		listePizza.add(new Pizza(7,"IND","L'indienne",14.00,CategoriePizza.VIANDE));
	}
	
	//METHODES
	@Override
	public List<Pizza> findAllPizzas() {
		for(int i=0;i<listePizza.size();i++){
			listePizza.get(i).toString();
		}
		return listePizza;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException{
		
		int index=findPizzaWithCode(pizza.getCode());
		if(index>=0){
			throw new SavePizzaException("Code pizza déjà dans le menu..");
		}
		
		int nbPizza=listePizza.size();
		pizza.setId(nbPizza);
		
		listePizza.add(pizza);
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException{
		
		int index=findPizzaWithCode(codePizza);
		
		if(index==-1){
			throw new UpdatePizzaException("Code non trouvé..");
		}
		
		System.out.println("Veuillez saisir le nouveau code");
		Scanner scan1=new Scanner(System.in); 
		String nouveauCode= scan1.nextLine();
		System.out.println("Veuillez saisir le nouveau nom");
		Scanner scan2=new Scanner(System.in);
		String nouveauNom= scan2.nextLine();
		System.out.println("Veuillez saisir le nouveau prix");
		Scanner scan3=new Scanner(System.in);
		double nouveauPrix= scan3.nextDouble();
		
		listePizza.get(index).setCode(nouveauCode);
		listePizza.get(index).setId(index);
		listePizza.get(index).setNom(nouveauNom);
		listePizza.get(index).setPrix(nouveauPrix);
		
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

 	private int tailleTab(Pizza[] tableau) {//Retourne le nombre de pizza dans le tableau
		int i=0;
		while(tableau[i]!=null){
			i++;
		}
		return i;
	}

	
	
	
 	//GETTERS SETTERS
	public List<Pizza> getListePizza() {
		return listePizza;
	}
	public void setListePizza(List<Pizza> listePizza) {
		this.listePizza = listePizza;
	}

}
