//Used to implement an object under the factory pattern

public class SpringRoll implements Roll{
	String type = "spring roll";
	Float price = 2.25F;

	@Override
	public String getType(){
		return this.type;
	}

	@Override
	public Float getPrice(){
		return this.price;
	}
}