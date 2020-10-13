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

	public void buy(StoreInventory storeInventory){
		System.out.println("========= "+this.type+" =========");

		this.order = this.buyBehavior.buy(storeInventory);
		if(this.order.get(0) == null){ //trigger to record order error by customer type
			int error = 0; //this will account for order errors
			this.order.remove(null);
			System.out.println(this.type+" customer's original order was not filled");
		}
		for(int i = 0; i < this.order.size(); i++){
			Roll roll = this.order.get(i);
			storeInventory.removeRoll(roll);
			System.out.println(roll.getType());
		}
	}
}