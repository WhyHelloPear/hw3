class ExtraFilling extends RollExtra {

  public ExtraFilling(Roll decoratedRoll, int num) {
    super(decoratedRoll);
    this.num = num;
    this.price = 0.25F;
  }

  public void printType(){
    this.decoratedRoll.printType();
    System.out.println("\t + " +Integer.toString(num) + " extra fillings");
  }
}
