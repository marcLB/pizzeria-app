package fr.pizzeria.console.client.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;

public class MenuConnect {

	private String titre="\n*** Pizzeria Client ***";
	
	private static final int COMMANDER_PIZZA=1;
	private static final int LISTER_COMMANDES=2;

	private  Map<Integer,OptionMenu> listeOptions=new HashMap<Integer,OptionMenu>();
	
	
	public MenuConnect(IPizzaDao pizzaDaoMenu){
		listeOptions.put(1,new CommandePizzaOptionMenu(pizzaDaoMenu));
		listeOptions.put(2,new ListerCommandeOptionMenu(pizzaDaoMenu));
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
