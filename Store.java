import java.util.Random;
import java.util.*;

//Main class used to manage the simulation
public class Store{
	static BuyBehavior casual = new CasualBuy();
	static BuyBehavior business = new BusinessBuy();
	static BuyBehavior catering = new CateringBuy();

	public static List<Customer> generateCustomers(){
		Random random = new Random();

		int numCasual = random.nextInt(12) + 1;
		int numBusiness = random.nextInt(3) + 1;
		int numCatering = random.nextInt(3) + 1;

		List<Customer> customers = new ArrayList<Customer>();

		for(int i = 0; i < numCasual; i++){
			Customer customer = new CasualCustomer();
			customer.setBuyBehavior(casual);
			customers.add(customer);
		}

		for(int i = 0; i < numBusiness; i++){
			Customer customer = new BusinessCustomer();
			customer.setBuyBehavior(business);
			customers.add(customer);
		}

		for(int i = 0; i < numCatering; i++){
			Customer customer = new CateringCustomer();
			customer.setBuyBehavior(catering);
			customers.add(customer);
		}

		Collections.shuffle(customers);

		return customers;

	}

	public static void main(String[] args){

		int days = 30; //number of days to simulate

		StoreInventory storeInventory = StoreInventory.getStoreInventory(); //getting singleton inventory item
		storeInventory.generateRolls("all"); //fill inventory with 30 rolls of each type
		List<Customer> customers = generateCustomers(); //get list of customers for the day
		
		int numCustomers = customers.size();
		for(int i = 0; i < numCustomers; i++){
			customers.get(i).buy();
		}

		for(int i = 0; i < days; i++){
			System.out.println("Day "+i+":");
			storeInventory.generateReport(); //print inventory report
			if(storeInventory.soldOut()){
				System.out.println("All rolls have been sold. Store is closing");
				break;
			}
		}
	}
}
