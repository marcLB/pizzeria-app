package fr.pizzeria.model;

public class Client {

	private int id;
	private String nom;
	private String prenom;
	private double solde;
	
	
	//CONSTRUCT
	public void Client(int id,String nom,String prenom,double solde){
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.solde=solde;
	}
	
	
	
	
	//METHODES
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
		
		return "";
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
}
