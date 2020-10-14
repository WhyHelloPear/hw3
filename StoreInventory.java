import java.util.*;
import java.util.Random;

//Singleton pattern used to track the store's inventory
public class StoreInventory{

	private static StoreInventory storeInventory = null;
	private RollFactory rollFactory;
	private List<Roll> inventory;
	public List<String> rollTypes;
	private int totalSold; //count of total number of rolls sold
	private int totalRevenue; //count of total revenue earned
	private List<String> customerTypes;
	private List<Integer> customerTurnaways;
	private List<Float> dailyCustomerRevenue;
	private List<Integer> dailyRollSales;
	private List<Integer> rollSales;

	private StoreInventory(){
		rollFactory = new RollFactory();
		inventory = new ArrayList<Roll>();
		rollTypes = new ArrayList<String>();
		rollTypes.add("egg");
		rollTypes.add("jelly");
		rollTypes.add("pastry");
		rollTypes.add("sausage");
		rollTypes.add("spring");
		customerTypes = new ArrayList<String>();
		customerTypes.add("casual");
		customerTypes.add("business");
		customerTypes.add("catering");
		customerTurnaways = new ArrayList<Integer>();
		dailyCustomerRevenue = new ArrayList<Float>();
		dailyRollSales = new ArrayList<Integer>();
		rollSales = new ArrayList<Integer>();

		for(String i: customerTypes){
			customerTurnaways.add(0);
			dailyCustomerRevenue.add(0F);
		}
		for(String i: rollTypes){
			rollSales.add(0);
			dailyRollSales.add(0);
		}

	}

	public static StoreInventory getStoreInventory(){
		if(storeInventory == null){
			storeInventory = new StoreInventory();
		}
		return storeInventory;
	}

	//generates a specefied roll type and adds it to store inventory
	public void generateRolls(String type){
		if(type == "all"){ //used to fill initial inventory with 30 of each type
			generateRolls("egg");
			generateRolls("jelly");
			generateRolls("pastry");
			generateRolls("sausage");
			generateRolls("spring");
		}
		else{ //refills inventory of specified type
			for(int i = 0; i < 30; i++){
				inventory.add(rollFactory.createRoll(type));
			}
		}
		shuffleInventory();
	}

	//returns the number of rolls currently in inventory
	public int getInventorySize(){
		return inventory.size();
	}

	//gets count of specified roll types in inventory
	public int getTypeCount(String type){
		int count = 0;
		int length = getInventorySize();

		//cycle over all rolls in the list
		for(int i = 0; i < length; i++){
			Roll roll = inventory.get(i);
			if(type == roll.getType()){ //check if roll type matches
				count++;
			}
		}
		return count;
	}

	public void logSale(Roll roll, String customerType){
		String rollType = roll.getType();
		Float price = roll.getPrice();
		int customerIndex = customerTypes.indexOf(customerType);
		int rollIndex = rollTypes.indexOf(rollType);

		dailyCustomerRevenue.set(customerIndex, dailyCustomerRevenue.get(customerIndex) + price);
		dailyRollSales.set(rollIndex, dailyRollSales.get(rollIndex) + 1);
		rollSales.set(rollIndex, rollSales.get(rollIndex) + 1);

	}

	//prints out the current inventory of all rolls
	public void generateReport(String time){
		System.out.println("Rolls In Inventory:");
		for (String rollType: rollTypes) {
			System.out.println("\t" + rollType + "\t" + getTypeCount(rollType));
		}

		if ( time.equals("close") ) {
			System.out.println("Rolls Sold Today:");
			for (String rollType: rollTypes) {
				int typeIndex = rollTypes.indexOf(rollType);
				System.out.println("\t" + rollType + "\t" + dailyRollSales.get(typeIndex));
			}

			System.out.println("Revenue Today:");
			Float totalRevenue = 0F;
			for (String customerType: customerTypes) {
				int customerIndex = customerTypes.indexOf(customerType);
				Float revenue = dailyCustomerRevenue.get(customerIndex);
				totalRevenue += revenue;
				System.out.println("\t" + customerType + "\t" + String.format("%.2f", revenue));
			}
			System.out.println("\tTOTAL\t" + String.format("%.2f", totalRevenue));



		}
	}

	public void newDay() {
		for (int i = 0; i < dailyCustomerRevenue.size(); i++) {
			dailyCustomerRevenue.set(i, 0F);
		}
		for (int i = 0; i < dailyRollSales.size(); i++) {
			dailyRollSales.set(i, 0);
		}
	}

	//given a desired amount, function returns a list of
	//roll types that have stock >= desired amount
	public List<String> getAvailableTypes(int amount){
		List<String> availableTypes = new ArrayList<String>();

		if(getTypeCount("egg") >= amount){
			availableTypes.add("egg");
		}
		if(getTypeCount("jelly") >= amount){
			availableTypes.add("jelly");
		}
		if(getTypeCount("pastry") >= amount){
			availableTypes.add("pastry");
		}
		if(getTypeCount("sausage") >= amount){
			availableTypes.add("sausage");
		}
		if(getTypeCount("spring") >= amount){
			availableTypes.add("spring");
		}

		return availableTypes;
	}

	//checks whether or not all rolls are sold out
	public Boolean soldOut(){
		Boolean value = false;
		List<String> available = getAvailableTypes(1); //checks if any roll type has at least 1 roll
		if(available.size() == 0){ //if all rolls are sold out
			value = true;
		}
		return value;
	}

	public Roll getRoll(int index){
		return inventory.get(index);
	}

	//removes roll from inventory when roll is sold in an order
	public void removeRoll(Roll roll){
		this.inventory.remove(roll);
	}

	public void shuffleInventory(){
		Collections.shuffle(this.inventory);
	}

	public void restock(){
		List<String> types = this.rollTypes;
		for(int i = 0; i < types.size(); i++){
			String type = types.get(i);
			if(getTypeCount(type) == 0){
				generateRolls(type);
			}
		}
	}

	public void addTurnaway(String type){
		int index = customerTypes.indexOf(type);
		int count = customerTurnaways.get(index);
		count++;
		customerTurnaways.set(index, count);
	}

	public void finalReport(){
		System.out.println("######### Final Report ##########");
		System.out.println("Turnaways:");
		int sumTurnaways = 0;
		for(int i = 0; i < 3; i++){
			System.out.println("\t" + customerTypes.get(i) + "\t" + customerTurnaways.get(i));
			sumTurnaways += customerTurnaways.get(i);
		}
		System.out.println("\tTOTAL\t" + sumTurnaways);

		System.out.println("Rolls Sold Overall:");
		int sumRolls = 0;
		for(String rollType: rollTypes) {
			int index = rollTypes.indexOf(rollType);
			System.out.println("\t" + rollType + "\t" + rollSales.get(index));
			sumRolls += rollSales.get(index);
		}
		System.out.println("\tTOTAL\t" + sumRolls);
	}
}
