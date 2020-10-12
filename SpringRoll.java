//Used to implement an object under the factory pattern

public class SpringRoll implements Roll{
	String type = "spring";
	Float price = 1.75F;

	@Override
	public String getType(){
		return this.type;
	}

	@Override
	public Float getPrice(){
		return this.price;
	}
}