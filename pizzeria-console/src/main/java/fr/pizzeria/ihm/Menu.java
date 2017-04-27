package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class Menu {

	private String titre="\n*** Menu ***";
	
	private static final int AFFICHER_PIZZAS=1;
	private static final int AJOUTER_PIZZAS=2;
	private static final int MODIFIER_PIZZAS=3;
	private static final int SUPPRIMER_PIZZAS=4;
	private static final int LISTER_CLIENT=5;
	private static final int AJOUTER_CLIENT=8;
	private static final int DEBITER_CLIENT=7;
	private static final int CREDITER_CLIENT=6;
	private static final int LISTER_LIVREURS=9;
	private static final int AFFICHER_STATISTIQUE=10;
	

	private  Map<Integer,OptionMenu> listeOptions=new HashMap<Integer,OptionMenu>();
	
	
	public Menu(IPizzaDao pizzaDaoMenu){
		listeOptions.put(1,new ListerPizzaOptionMenu(pizzaDaoMenu));
		listeOptions.put(2,new NouvellePizzaOptionMenu(pizzaDaoMenu));
		listeOptions.put(3,new ModifierPizzaOptionMenu(pizzaDaoMenu));
		listeOptions.put(4,new SupprimerPizzaOptionMenu(pizzaDaoMenu));
		listeOptions.put(5,new ListerClientOptionMenu(pizzaDaoMenu));
		listeOptions.put(6,new AjouterClientOptionMenu(pizzaDaoMenu));
		listeOptions.put(7,new CrediterClientOptionMenu(pizzaDaoMenu));
//		listeOptions.put(8,new DebiterClientOptionMenu());
//		listeOptions.put(9,new ListerLivreurOptionMenu());
//		listeOptions.put(10,new AfficherStatsCompteOptionMenu());
		listeOptions.put(8,new ImporterDonneesOptionMenu(pizzaDaoMenu));
	}
	
	
	public void afficher(){
		System.out.println(titre);
		for(int i=1;i<=listeOptions.size();i++){
			System.out.println(listeOptions.get(i).getLibelle());
		}
		System.out.println("99. Sortir");
	}

	public void choixUtilisateur(){
		int keyUser;
		do{
			afficher();
			Scanner scan=new Scanner(System.in); 
			keyUser = scan.nextInt();
			
			if(keyUser!=99){
				listeOptions.get(keyUser).execute();
			}
		}while(keyUser!=99);{
			System.out.println("Aurevoir");
		}
	}
}	
