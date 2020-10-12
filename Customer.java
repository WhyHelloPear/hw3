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
		this.buyBehavior.buy(inventory);
	}
}