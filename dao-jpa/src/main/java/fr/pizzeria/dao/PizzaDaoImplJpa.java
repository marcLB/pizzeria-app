package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplJpa implements IPizzaDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizzeria-unit");
	private EntityManager em;

	protected void openEntityManager() {
		em = entityManagerFactory.createEntityManager();
	}

	protected void closeEntityManager() {
		em.close();
	}

	@Override
	public List<Pizza> findAllPizzas() {
		openEntityManager();

		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		List<Pizza> resultList = query.getResultList();

		closeEntityManager();
		return resultList;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		openEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();

		Pizza p= new Pizza();
		p.setCode(pizza.getCode());
		p.setNom(pizza.getNom());
		p.setPrix(pizza.getPrix());
		p.setCategoriePizza(pizza.getCategoriePizza());
	
		em.persist(p);
		et.commit();
	
		closeEntityManager();
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		openEntityManager();
		EntityTransaction et = em.getTransaction();

		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:CODE", Pizza.class)
				.setParameter("CODE", codePizza);

		Pizza p = query.getResultList().get(0);

		et.begin();
		if (p != null) {
			p.setCode(pizza.getCode());
			p.setNom(pizza.getNom());
			p.setPrix(pizza.getPrix());
			p.setCategoriePizza(pizza.getCategoriePizza());
		}
		et.commit();
		
//		et.begin();
//		if (p != null) {
//			Pizza p2 = new Pizza();
//			p2.setId(pizza.getId());
//			p2.setCode(pizza.getCode());
//			p2.setNom(pizza.getNom());
//			p2.setPrix(pizza.getPrix());
//			p2.setCategoriePizza(pizza.getCategoriePizza());
//			em.merge(p2);
//		}
//		et.commit();
//		
		closeEntityManager();

		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		openEntityManager();
		EntityTransaction et = em.getTransaction();

		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:CODE", Pizza.class)
				.setParameter("CODE", codePizza);

		Pizza p = query.getResultList().get(0);

		et.begin();
		if (p != null) {
			em.remove(p);
		}
		et.commit();
		closeEntityManager();
		return false;
	}

	@Override
	public List<Client> findAllClients() {
		openEntityManager();

		closeEntityManager();
		return null;
	}

	@Override
	public boolean saveNewClient(Client client) {
		openEntityManager();
	
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(client);
		
		et.commit();
		
		closeEntityManager();
		return false;
	}

	@Override
	public void importData() {
		// TODO Auto-generated method stub

	}

}
