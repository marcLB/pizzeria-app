package fr.pizzeria.model;

public enum CategoriePizza {

	VIANDE("Viande"),
	POISSON("Poisson"),
	SANS_VIANDE("Sans Viande"),
	SANS_CATEGORIE("");
	
	private String categoriePizza; 
	
	CategoriePizza(String categoriePizza){
		
	}

	public String getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(String categoriePizza) {
		this.categoriePizza = categoriePizza;
	}
	
}
