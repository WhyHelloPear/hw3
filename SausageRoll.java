//Used to implement an object under the factory pattern

public class SausageRoll implements Roll{
	String type = "sausage roll";
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