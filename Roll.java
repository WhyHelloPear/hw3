abstract class Roll{
	String type;
	Float price;

	public String getType(){
		return this.type;
	}

	public Float getPrice(){
		return this.price;
	}

	public void printType(){
		System.out.println(getType());
	}
}
