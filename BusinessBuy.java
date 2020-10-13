import java.util.*;

public class BusinessBuy implements BuyBehavior{
	public List<Roll> buy(StoreInventory storeInventory){

		// 1) if types do not have a stock of 2 of each stock, indicate error
			// 1a) order will be discarded and functions returns a list filled with a single null value
		// 2) if original order can be placed, select 2 rolls of each type and return order

		List<Roll> order = new ArrayList<Roll>();

		List<String> availableTypes = storeInventory.getAvailableTypes(2);

		if(availableTypes.size() < 5){ //original order cannot be filled
			order.add(null); //add indicator to list; this will be the only value in the list
		}
		else{ //fill original order
			int eggCount = 0; //each roll count variable tracks how many of each type has been selected
			int jellyCount = 0;
			int pastryCount = 0;
			int sausageCount = 0;
			int springCount = 0;
			for(int i = 0; i < storeInventory.getInventorySize(); i++){ //loop over all rolls in inventory
				Roll roll = storeInventory.getRoll(i); //get roll
				String type = roll.getType(); //save roll type
				if(type == "egg" && eggCount < 2){
					eggCount++;
					order.add(roll);
				}
				else if(type == "jelly" && jellyCount < 2){
					jellyCount++;
					order.add(roll);
				}
				else if(type == "pastry" && pastryCount < 2){
					pastryCount++;
					order.add(roll);
				}
				else if(type == "sausage" && sausageCount < 2){
					sausageCount++;
					order.add(roll);
				}
				else if(type == "spring" && springCount < 2){
					springCount++;
					order.add(roll);
				}
				if((eggCount+jellyCount+pastryCount+sausageCount+springCount) == 10){ //if order has been filled
					break; //end the loop
				}
			}
		}
		return order; //return customer order
	}
}