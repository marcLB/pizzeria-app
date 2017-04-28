package fr.pizzeria.dao.jdbc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.dao.fichier.PizzaDaoImplFichier;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplJDBC implements IPizzaDao{
	
	static{		
		try {Class.forName("com.mysql.jdbc.Driver");}
		catch (ClassNotFoundException e) {throw new RuntimeException(e);}		
	}
	
	private Connection maConnection;
	private Statement statement;
	
	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> listePizza= new ArrayList<Pizza>();
		try{
			connectionBDD();
			ResultSet result = statement.executeQuery("SELECT * FROM pizzas");
			
			while(result.next()){
				listePizza.add(new Pizza(
						result.getString("CODE"),
						result.getString("NOM"),
						result.getDouble("PRIX"),
						CategoriePizza.valueOf(result.getString("CATEGORIE"))
						));		
			}
			result.close();
		}
		catch (SQLException e) {throw new RuntimeException(e);}
		closeBDD();
		return listePizza;
		
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		connectionBDD();
	
		String code=pizza.getCode();
		String nom=pizza.getNom();
		double prix=pizza.getPrix();
		CategoriePizza categorie = pizza.getCategoriePizza();
		
		try {
			statement.executeUpdate("INSERT INTO `pizzas` (`CODE`,`NOM`,`PRIX`,`CATEGORIE`) "
					+ "VALUES ('"+code+"','"+nom+"','"+prix+"','"+categorie+"')");
			maConnection.commit();
		}
		catch (SQLException e) {e.printStackTrace();}
		try {
			maConnection.rollback();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		closeBDD();
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		connectionBDD();
		
		
		String code = pizza.getCode();
		String nom = pizza.getNom();
		double prix= pizza.getPrix();
		CategoriePizza categorie = pizza.getCategoriePizza();
		
		try {
			statement.executeUpdate("UPDATE `pizzas` SET"
									+ " `CODE`='"+code+"',"
									+ " `NOM`='"+nom+"',"
									+ " `PRIX`="+prix+","
									+ " `CATEGORIE`='"+categorie+"'"
									+ " WHERE CODE='"+codePizza+"';");
			maConnection.commit();
		}
		catch (SQLException e) {
			try {
				maConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		closeBDD();
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		connectionBDD();
		
		try {
			statement.executeUpdate("DELETE FROM `pizzas` WHERE CODE='"+codePizza+"';");
			maConnection.commit();
		}
		catch (SQLException e) {
			try {
				maConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			}
		closeBDD();
		return false;
	}

	
	@Override
	public List<Client> findAllClients() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean saveNewClient(Client client) {
		return false;
	}

	private void connectionBDD(){
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

		String URL_BDD = bundle.getString("URL_BDD");;
		String USERNAME_BDD = bundle.getString("USERNAME_BDD");
		String MDP_BDD = bundle.getString("MDP_BDD");;
		
		try{maConnection = DriverManager.getConnection(URL_BDD,USERNAME_BDD,MDP_BDD);
		maConnection.setAutoCommit(false);}
		catch (SQLException e) {e.printStackTrace();}
		
		try{statement = maConnection.createStatement();
		} 
		catch (SQLException e) {e.printStackTrace();}
	}
	private void closeBDD(){
		try {
			maConnection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void importData() {
		connectionBDD();
		
		PizzaDaoImplFichier daoFichier = new PizzaDaoImplFichier();
		List<Pizza> listePizza = daoFichier.findAllPizzas();
		
		for(int i=0;i<listePizza.size();i++){
			saveNewPizza(listePizza.get(i));
		}
		
		closeBDD();
	}
}
