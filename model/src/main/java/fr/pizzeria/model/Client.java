package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="NOM")
	private String nom;
	@Column(name="PRENOM")
	private String prenom;
	@Column(name="EMAIL")
	private String email;
	@Column(name="MOT_DE_PASSE")
	private int mot_de_passe;
	
	
	
	//CONSTRUCT
	
	public Client(){
		
	}
	
	public Client(String nom,String prenom,String email,int mot_de_passe){
		this.nom=nom;
		this.prenom=prenom;
		this.setEmail(email);
		this.setMot_de_passe(mot_de_passe);
	}
	
	
	//METHODES
	
/*
	public void crediterCompte(double montant){
		this.solde+=montant;
		
		if(solde>5000){
			//CreditException
		}
	}
	
	public void debiterCompte(double montant){
		this.solde-=montant;
		
		if(solde<0){
			//DebitException
		}
	}
	
	public String toString(){
		return id+" -> "+prenom+" "+nom+" ("+solde+"€ )";
	}
*/	
	
	
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
//	public double getSolde() {
//		return solde;
//	}
//	public void setSolde(double solde) {
//		this.solde = solde;
//	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getMot_de_passe() {
		return mot_de_passe;
	}


	public void setMot_de_passe(int mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
}