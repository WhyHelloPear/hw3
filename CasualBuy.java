import java.util.Random;
import java.util.*;

public class CasualBuy implements BuyBehavior{

	public List<Roll> buy(StoreInventory storeInventory){
		Random random = new Random();

		int orderSize = random.nextInt(3) + 1;

		List<Roll> order = new ArrayList<Roll>(); //will store customer's order
		int inventorySize = storeInventory.getInventorySize();
		if(inventorySize <= orderSize){ //if store inventory has less than customer order; give customer all of inventory
			order.add(null); //indicates original order was not properly filled
			for(int i = 0; i < inventorySize; i++){ //loop over all of store inventory
				order.add(storeInventory.getRoll(i)); //add roll to customer order
			}		}
		else{ //store can properly fill original order
			List<Integer> indices = new ArrayList<Integer>(); //make sure we don't select same roll object twice
			while(order.size() < orderSize){ //loop until order is filled
				int index = random.nextInt(inventorySize);
				if(indices.contains(index) == false){
					indices.add(index);
					order.add(storeInventory.getRoll(index));
				}
			}
		}

		return order; //return customer order

	}
}