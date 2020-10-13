public abstract class RollExtra extends Roll {
  protected Roll decoratedRoll;
  int num;
  Float price;


  public RollExtra(Roll decoratedRoll){
    this.decoratedRoll = decoratedRoll;
  }

  public Float getPrice(){
    return this.decoratedRoll.getPrice() + this.price * this.num;
  }

  public String getType(){
		return this.decoratedRoll.getType();
	}

}
