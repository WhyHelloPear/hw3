import java.util.*;

public class CateringBuy implements BuyBehavior{
	public void buy(StoreInventory storeInventory){
		int length = storeInventory.getInventorySize();


		List<String> types = storeInventory.getRandomTypes(3);
		System.out.println(types);

		for(int i = 0; i < types.size(); i++){
			int typeCount = storeInventory.getTypeCount(types.get(i));
			System.out.println(types.get(i)+typeCount);
		}
		// for(int i = 0; i < storeInventory.rollTypes.size(); i++){
		// 	System.out.println(storeInventory.rollTypes.get(i));

		// }
		System.out.println("do catering stuff");
	}
}