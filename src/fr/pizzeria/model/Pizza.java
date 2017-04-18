package fr.pizzeria.model;

import java.lang.reflect.Field;

public class Pizza {
	private int id;
	
	@ToString(toUppercase=true)
	private String nom;
	@ToString(toUppercase=true)
	private double prix;
	@ToString(toUppercase=true)
	private String code;
	
	private CategoriePizza categoriePizza;
	
	
	public Pizza(int id, String code, String nom, double prix,CategoriePizza categorierPizza) {
		super();
		this.setId(id);
		this.nom = nom;
		this.code = code;
		this.prix = prix;
		this.categoriePizza=categorierPizza;
	}
	
	public String toString(){
		String chaine="";		
		try{
			for(Field field:this.getClass().getDeclaredFields()){
				ToString annotation=field.getAnnotation(ToString.class);
				if(annotation!=null){
					boolean toUpperCase=annotation.toUppercase();
					if(toUpperCase){
						chaine+=" "+field.get(this).toString().toUpperCase();
					}else{
						chaine+=" "+field.get(this).toString();
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Illegal acces");
		}
		System.out.println(code+" -> "+nom+" de la catégorie "+categoriePizza+" ("+prix+"€)");
		return chaine;
	}
	
	
	
	
	// GETTERS SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}
	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}
 
}