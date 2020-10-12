public abstract class Customer{
	String type;
	BuyBehavior buyBehavior;

	public Customer(String type){
		this.type = type;
	}

	public void setBuyBehavior(BuyBehavior behavior){
		this.buyBehavior = behavior;
	}

	public void buy(){
		this.buyBehavior.buy();
	}
}