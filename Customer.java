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

	private Roll addExtras (Roll roll){
		Random random = new Random();
		int num_sauces = random.nextInt(4);
		int num_fillings = random.nextInt(2);
		int num_toppings = random.nextInt(3);

		if(num_sauces > 0){
			roll = new ExtraSauce(roll, num_sauces);
		}
		if(num_fillings > 0){
			roll = new ExtraFilling(roll, num_fillings);
		}
		if(num_toppings > 0){
			roll = new ExtraTopping(roll, num_toppings);
		}

		return roll;
	}

	public void buy(StoreInventory storeInventory){
		System.out.println("========= "+this.type+" =========");

		this.order = this.buyBehavior.buy(storeInventory);
		if(this.order.get(0) == null){ //trigger to record order error by customer type
			int error = 0; //this will account for order errors
			this.order.remove(null);
			storeInventory.addTurnaway(this.type);
			System.out.println(this.type+" customer's original order was not filled");
		}
		for(int i = 0; i < this.order.size(); i++){
			Roll new_roll = addExtras(this.order.get(i));
			this.order.set(i, new_roll);
		}
		Float orderCost = 0F;
		for(int i = 0; i < this.order.size(); i++){
			Roll roll = this.order.get(i);
			storeInventory.removeRoll(roll.getBaseRoll());
			roll.printType();
			storeInventory.logSale(roll, this.type);
			orderCost += roll.getPrice();
		}
		System.out.println("ORDER COST: " + String.format("%.2f", orderCost));

	}
}
