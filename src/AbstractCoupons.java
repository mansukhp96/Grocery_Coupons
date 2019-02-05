public abstract class AbstractCoupons implements Coupons {

  private float value;
  public String item;

  @Override
  public abstract float finalPrice();

  @Override
  public String getDescription() {
    return toString();
  }

//  public static void main(String[] args) {
//    //amountOff amtOff = new amountOff();
//    percentOff prcOff = new percentOff(5,"Milk");
//    //amountOff amtOff = new amountOff(5,"Milk");
//    //buyXGetY bXGY = new buyXGetY();
//    //System.out.println(amtOff.getDescription());
//    System.out.println(prcOff.finalPrice());
//    System.out.println(prcOff.getDescription());
//    //System.out.println(bXGY.getDescription());
//  }
}
