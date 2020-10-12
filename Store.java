import java.util.Random;
import java.util.*;

//Main class used to manage the simulation
public class Store{


	public static void main(String[] args){

		int days = 30; //number of days to simulate

		StoreInventory storeInventory = StoreInventory.getStoreInventory(); //getting singleton inventory item
		storeInventory.generateRolls("all");
		System.out.println(storeInventory.getInventorySize());
		System.out.println(storeInventory.getTypeCount("jelly"));

	}
}
