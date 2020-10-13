class ExtraSauce extends RollExtra {

  public ExtraSauce(Roll decoratedRoll, int num) {
    super(decoratedRoll);
    this.num = num;
    this.price = 0.20F;
  }

  public void printType(){
    this.decoratedRoll.printType();
    System.out.println("\t + " +Integer.toString(num) + " extra sauce");
  }
}
