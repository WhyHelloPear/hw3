//Used to implement an object under the factory pattern

public class PastryRoll implements Roll{
	String type = "pastry";
	Float price = 3.50F;

	@Override
	public String getType(){
		return this.type;
	}

	@Override
	public Float getPrice(){
		return this.price;
	}
}