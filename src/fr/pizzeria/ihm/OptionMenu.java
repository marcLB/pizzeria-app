package fr.pizzeria.ihm;

public abstract class OptionMenu {

	protected IPizzaDao pizzaDao;
	protected String libelle;
	public abstract boolean execute();
	
	
	public OptionMenu(IPizzaDao pizzaDao){
		this.pizzaDao=pizzaDao;
	}
	
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
