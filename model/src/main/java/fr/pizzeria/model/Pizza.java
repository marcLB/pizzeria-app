package fr.pizzeria.model;

import java.lang.reflect.Field;
import javax.persistence.*;


@Entity
@Table(name="pizzas")
public class Pizza {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ToString(toUppercase=true)
	private String id;

	
	@Column(name="NOM")
	@ToString(toUppercase=true)
	private String nom;
	
	@Column(name="PRIX")
	@ToString(toUppercase=true)
	private double prix;
	
	@Column(name="CODE")
	@ToString(toUppercase=true)
	private String code;
	
	@Enumerated(EnumType.STRING)
	@Column(name="CATEGORIE")
	private CategoriePizza categoriePizza;
	
	public Pizza(){
		
	}
	
	public Pizza(String code, String nom, double prix,CategoriePizza categorierPizza) {
		super();
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
 
}