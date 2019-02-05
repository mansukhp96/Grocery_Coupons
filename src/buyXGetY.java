//public class buyXGetY extends AbstractCoupons implements Coupons {
//
//  private float value;
//  private String item;
//  private float price;
//  private float unitPrice;
//  private int x;
//  private int y;
//
//  public buyXGetY(float value, String item) {
//    this.value = value;
//    this.item = item;
//  }
//
//  @Override
//  public float finalPrice() {
//    price = finalPriceHelper(x, y);
//    return price;
//  }
//
//  private float finalPriceHelper(float x, float y) {
//    price = x * unitPrice;
//    return price;
//  }
//
//  @Override
//  public String toString() {
//    String str = "Buy " + x + " Get " + y + " on " + item;
//    return str;
//  }
//}
