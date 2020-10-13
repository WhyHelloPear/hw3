import java.util.*;
import java.util.Random;

public class CateringBuy implements BuyBehavior{
	public List<Roll> buy(StoreInventory storeInventory){

		// 1) randomly select 3 roll types to buy
		// 2) if cannot buy 5 of selected types, indicate error
			// 2a) fill original order as close as possible (if type count = 5; add 5 of those to order)
			// 2b) randomly fill the rest of the order


		Random random = new Random();
		List<Roll> order = new ArrayList<Roll>(); //will store customer's order
		List<String> selectedTypes = new ArrayList<String>(); //will hold customer's original type preference
		List<Integer> typeCount = new ArrayList<Integer>();
		List<String> rollTypes = storeInventory.rollTypes; //holds list of roll types
		List<Integer> typeIndices = new ArrayList<Integer>(); //will hold randomly selected ints so we don't choose same roll type twice
		List<String> availableTypes = storeInventory.getAvailableTypes(5); //gets available types with a stock of 5 rolls

		while(typeIndices.size() < 3){ //loop until we have selected 3 unique types
			int index = random.nextInt(5); //get random number
			if(!typeIndices.contains(index)){ //if number has NOT been used yet
				typeIndices.add(index); //save the number so we don't use it again
				String type = rollTypes.get(index);
				if(!availableTypes.contains(type)){ //if customer's preference is not available
					if(!order.contains(null)){ //if error has NOT been flagged yet
						order.add(null); //indicate customer's original order cannot be placed
					}
				}
				selectedTypes.add(type); //add type preference to selected types
				typeCount.add(0);
			}
		}
		int size = storeInventory.getInventorySize();
		List<Integer> indices = new ArrayList<Integer>();
		for(int i = 0; i < size; i++){
			Roll roll = storeInventory.getRoll(i);
			String type = roll.getType();
			int typeIndex = selectedTypes.indexOf(type);

			if(selectedTypes.contains(type)){
				int count = typeCount.get(typeIndex);
				if(count < 5){
					count++;
					indices.add(i);
					order.add(roll);
					typeCount.set(typeIndex, count);
				}
			}
		}
		int desiredSize = 15;
		if(order.contains(null)){
			desiredSize = 16;
		}
		if(order.size() < desiredSize){
			for(int i = 0; i < size; i++){
				if(!indices.contains(i)){
					Roll roll = storeInventory.getRoll(i);
					indices.add(i);
					order.add(roll);
				}
				if(order.size() == desiredSize){
					break;
				}
			}
		}


		return order; //return customer order

	}
}