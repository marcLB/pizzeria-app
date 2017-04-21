package fr.pizzeria.dao.fichier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplFichier implements IPizzaDao{
	protected String DATA_DIR;
	
	public PizzaDaoImplFichier(String dataDir) {
		this.DATA_DIR=dataDir;
	}
	

	@Override
	public List<Pizza> findAllPizzas() {
		try(Stream<Path> list = Files.list(Paths.get(DATA_DIR+"pizzas/"));){
			return list
					.map(path -> {
					String code = path.toFile().getName().replaceAll(".txt", "");
			
				try(Stream<String> lines = Files.lines(path);){	
				
				String[] valueTab = lines
						.findFirst()
						.orElseThrow(() -> new StockageException("fichier vide"))
						.split(";");
				return new Pizza(code,valueTab[0],Double.valueOf(valueTab[1]),CategoriePizza.valueOf(valueTab[2]));
				
			}catch(IOException e){
				throw new StockageException(e);
			}
		}).collect(Collectors.toList());
			
		}catch(IOException e){
			throw new StockageException(e);
		}
		
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		File pizzaFile=new File(DATA_DIR+"pizzas/"+pizza.getCode()+".txt"); 
		try {
			pizzaFile.createNewFile();
			FileWriter fileW=new FileWriter(pizzaFile);
			fileW.write(
					pizza.getNom()+";"+
					pizza.getPrix()+";"+
					pizza.getCategoriePizza()
					); 
			fileW.close(); 
		} catch (IOException e) {
			throw new SavePizzaException("probleme à l'enregistrement");
		}
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		deletePizza(codePizza);
		saveNewPizza(pizza);
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
				
		        File file = new File(DATA_DIR+codePizza+".txt");
		        if (file.exists() && file.canWrite()) {
		        	file.delete();
		        	file.deleteOnExit();
		        }
		return false;
	}

	@Override
	public List<Client> findAllClients() {
		
		try(Stream<Path> list = Files.list(Paths.get(DATA_DIR+"clients/"));){
			return list
					.map(path -> {
					String code = path.toFile().getName().replaceAll(".txt", "");
				try(Stream<String> lines = Files.lines(path);){	
				String[] valueTab = lines
						.findFirst()
						.orElseThrow(() -> new StockageException("fichier vide"))
						.split(";");
				return new Client(Integer.valueOf(valueTab[0]),valueTab[1],valueTab[2],Double.valueOf(valueTab[3]));
				
			}catch(IOException e){
				throw new StockageException(e);
			}
		}).collect(Collectors.toList());
			
		}catch(IOException e){
			throw new StockageException(e);
		}
	}

	@Override
	public boolean saveNewClient(Client client) {
		File pizzaFile=new File(DATA_DIR+"clients/"+client.getNom()+" "+client.getPrenom()+".txt"); 
		try {
			pizzaFile.createNewFile();
			FileWriter fileW=new FileWriter(pizzaFile);
			fileW.write(
					client.getId()+";"+
					client.getNom()+";"+
					client.getPrenom()+";"+
					client.getSolde()
					); 
			fileW.close(); 
		} catch (IOException e) {
			throw new SavePizzaException("probleme à l'enregistrement");
		}
		return false;
	}
}
