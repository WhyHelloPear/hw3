//Used to implement an object under the factory pattern

public class JellyRoll implements Roll{
	String type = "jelly";
	Float price = 3.00F;

	@Override
	public String getType(){
		return this.type;
	}

	@Override
	public Float getPrice(){
		return this.price;
	}
}