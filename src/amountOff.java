//public class amountOff extends AbstractCoupons implements Coupons {
//
//  private float aOffValue;
//  private String item;
//  private float price;
//
//  public amountOff(float aOffValue, String item) {
//    this.aOffValue = aOffValue;
//    this.item = item;
//    this.price = 10;
//  }
//
//  @Override
//  public float finalPrice() {
//    price = finalPriceHelper(aOffValue);
//    return price;
//  }
//
//  private float finalPriceHelper(float aOffValue) {
//    price = price - aOffValue;
//    return price;
//  }
//
//  @Override
//  public String toString() {
//    String str = "$" + aOffValue + " off on " + item;
//    return str;
//  }
//}
