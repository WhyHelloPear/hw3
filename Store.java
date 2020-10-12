import java.util.Random;
import java.util.*;

//Main class used to manage the simulation
public class Store{


	public static void main(String[] args){

		int days = 30; //number of days to simulate


		List<Roll> rollInventory = new ArrayList<Roll>(); //list of rolls in the shop's daily inventory
		RollFactory rollFactory = new RollFactory(); //factory object used to generate rolls

		//this for loop is used to generate 30 rolls of each type
		//each roll gets added to the starting store inventory
		for(int i = 0; i < 30; i++){
			Roll egg = rollFactory.createRoll("egg");
			rollInventory.add(egg);
			Roll jelly = rollFactory.createRoll("jelly");
			rollInventory.add(jelly);
			Roll pastry = rollFactory.createRoll("pastry");
			rollInventory.add(pastry);
			Roll sausage = rollFactory.createRoll("sausage");
			rollInventory.add(sausage);
			Roll spring = rollFactory.createRoll("spring");
			rollInventory.add(spring);
		}

		System.out.println(rollInventory.size());


	}
}
