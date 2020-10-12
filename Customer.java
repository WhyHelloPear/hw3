import java.util.*;

public abstract class Customer{
	String type;
	BuyBehavior buyBehavior;
	List<Roll> order;

	public Customer(String type){
		this.type = type;
		List<Roll> order = new ArrayList<Roll>();
	}

	public void setBuyBehavior(BuyBehavior behavior){
		this.buyBehavior = behavior;
	}

	public void buy(StoreInventory inventory){
		this.order = this.buyBehavior.buy(inventory);
		System.out.println("=============================");
		for(int i = 0; i < order.size(); i++){
			System.out.println(order.get(i).getType());
		}
		System.out.println("=============================");
	}
}