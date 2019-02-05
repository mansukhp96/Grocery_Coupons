public class amountOff extends AbstractCoupons implements Coupons {

  private float aOffValue;
  private String item;
  private float unitPrice;
  private int quantity;

  public amountOff(int quantity, float unitPrice, String item, float aOffValue) {
    this.aOffValue = aOffValue;
    this.item = item;
    this.unitPrice = unitPrice;
    this.quantity = quantity;
  }

  @Override
  public float finalPrice() {
    float discountPrice = finalPriceHelper(quantity, unitPrice, item, aOffValue);
    return discountPrice;
  }

  public amountOff stackCoupons(amountOff cou) {
    if (cou instanceof amountOff) {
      if (this.item == cou.item && this.unitPrice == cou.unitPrice && this.quantity == cou.quantity) {
        cou.aOffValue = this.aOffValue + cou.aOffValue;
        float newDisc = finalPriceHelper(quantity, unitPrice, item, this.aOffValue + cou.aOffValue);
        //System.out.println("/"+newDisc);
        return cou;
      } else {
        throw new IllegalArgumentException("Not Stackable!");
      }
    } else {
      throw new IllegalArgumentException("Not Stackable!");
    }
  }

  private float finalPriceHelper(int quantity, float unitPrice, String item, float aOffValue) {
    float totalPrice = unitPrice * quantity;
    float discountPrice = (totalPrice - aOffValue);
    return discountPrice;
  }

  @Override
  public String getDescription() {
    return super.getDescription();
  }

  @Override
  public String toString() {
    String str = "$" + aOffValue + " off on " + item;
    return str;
  }

  public static void main(String[] args) {
    amountOff n = new amountOff(10,2,"Curd", 2);
    amountOff n1 = new amountOff(10,2,"Curd", 1);
    System.out.println(n.stackCoupons(n1).finalPrice());
  }
}
