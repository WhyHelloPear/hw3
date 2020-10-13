class ExtraTopping extends RollExtra {

  public ExtraTopping(Roll decoratedRoll, int num) {
    super(decoratedRoll);
    this.num = num;
    this.price = 0.10F;
  }

  public void printType(){
    this.decoratedRoll.printType();
    System.out.println("\t + " +Integer.toString(num) + " extra topping");
  }
}
