package fr.pizzeria.dao.pizza;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplFichier implements IPizzaDao{
	protected String DATA_DIR;
	
	public PizzaDaoImplFichier(String dataDir) {
		this.DATA_DIR=dataDir;
	}

	public static void main(String[] args) throws IOException{
		
	}
	

	@Override
	public List<Pizza> findAllPizzas() {
		try{
			
			return Files.list(Paths.get("data"))
					.map(path -> {
					String code = path.toFile().getName().replaceAll(".txt", "");
			
			try{	
				String[] valueTab = Files.lines(path)
						.findFirst()
						.orElseThrow(() -> new StockageException("fichier vide"))
						.split(";");
				return new Pizza(Integer.valueOf(valueTab[0]),code,valueTab[1],Double.valueOf(valueTab[2]),CategoriePizza.valueOf(valueTab[3]));
				
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
		
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		// TODO Auto-generated method stub
		return false;
	}

}
