package fr.pizzeria.dao.pizza;



import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.dao.pizza.PizzaDaoImplTableau;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTableauTest {
	
	@Test
	public void test_findAllPizzas_a_l_initialisation(){
		PizzaDaoImplTableau pizzaDaoImplTableau = new PizzaDaoImplTableau();
		
		List<Pizza> resultat = pizzaDaoImplTableau.findAllPizzas();
		
		Assert.assertNotNull(resultat);
		Assert.assertTrue("La liste devrait être vide", !resultat.isEmpty());
	}
}
