package fr.pizzeria.console.client.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;

public class MenuLogin {

	private String titre="\n*** Pizzeria Client ***";
	
	private static final int INSCRIPTION=1;
	private static final int CONNEXION=2;

	private  Map<Integer,OptionMenu> listeOptions=new HashMap<Integer,OptionMenu>();
	
	
	public MenuLogin(IPizzaDao pizzaDaoMenu){
		listeOptions.put(1,new InscriptionClientOptionMenu(pizzaDaoMenu));
		listeOptions.put(2,new ConnexionClientOptionMenu(pizzaDaoMenu));
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
