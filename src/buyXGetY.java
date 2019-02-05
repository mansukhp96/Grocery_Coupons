//public class buyXGetY extends AbstractCoupons implements Coupons {
//
//  private String item;
//  private float unitPrice;
//  private int quantity;
//  private int x;
//  private int y;
//
//  public buyXGetY(int quantity, float unitPrice, String item, int x, int y) {
//    this.quantity = quantity;
//    this.unitPrice = unitPrice;
//    this.item = item;
//    this.x = x;
//    this.y = y;
//    if (quantity <= 0 || unitPrice <= 0 || item == "" || item == null || x <= 0 || y <= 0) {
//      throw new IllegalArgumentException("Invalid Argument!");
//    }
//  }
//
//  @Override
//  public float finalPrice() {
//    float discountPrice = finalPriceHelper(quantity, unitPrice,item, x,y);
//    return discountPrice;
//  }
//
//  private float finalPriceHelper(int quantity, float unitPrice, String item, int x, int y) {
//    float discountPrice = x * unitPrice;
//    return discountPrice;
//  }
//
//  @Override
//  public String toString() {
//    String str = "Buy " + x + " Get " + y + " on " + item;
//    return str;
//  }
//
//  public static void main(String[] args) {
//    buyXGetY b = new buyXGetY(4, 2, "napkins", 2,2);
//    System.out.println(b.finalPrice());
//  }
//}
