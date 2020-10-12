import java.util.*;
import java.util.Random;

public class CateringBuy implements BuyBehavior{
	public List<Roll> buy(StoreInventory storeInventory){
		Random random = new Random();

		int orderSize = random.nextInt(3) + 1;

		List<Roll> order = new ArrayList<Roll>(); //will store customer's order

		int inventorySize = storeInventory.getInventorySize();
		if(inventorySize <= orderSize){ //if store inventory has less than customer order; give customer all of inventory
			for(int i = 0; i < inventorySize; i++){ //loop over all of store inventory
				order.add(storeInventory.getRoll(i)); //add roll to customer order
			}
		}
		else{
			List<Integer> indices = new ArrayList<Integer>();
			while(order.size() < orderSize){
				int index = random.nextInt(inventorySize);
				if(indices.contains(index) == false){
					indices.add(index);
					order.add(storeInventory.getRoll(index));
				}
			}
		}

		return order;

	}
}