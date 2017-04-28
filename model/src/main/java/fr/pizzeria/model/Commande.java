package fr.pizzeria.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="commande")
public class Commande {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="NUMERO_COMMANDE")
	private int numero_commande;
	@Column(name="STATUT")	
	private String statut;
	@Column(name="DATE_COMMANDE")		
	private Date date_commande;
	@Column(name="LIVREUR_ID")		
	private int livreur_id;
	@Column(name="CLIENT_ID")		
	private int client_id;
	
	//CONSTRUCTEURS
	public Commande(int id, int numero_commande, String statut, Date date_commande, int livreur_id, int client_id) {
		super();
		this.id = id;
		this.numero_commande = numero_commande;
		this.statut = statut;
		this.date_commande = date_commande;
		this.livreur_id = livreur_id;
		this.client_id = client_id;
	}
	
	
	
	
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero_commande() {
		return numero_commande;
	}
	public void setNumero_commande(int numero_commande) {
		this.numero_commande = numero_commande;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Date getDate_commande() {
		return date_commande;
	}
	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}
	public int getLivreur_id() {
		return livreur_id;
	}
	public void setLivreur_id(int livreur_id) {
		this.livreur_id = livreur_id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	
}
