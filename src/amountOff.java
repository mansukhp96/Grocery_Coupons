public class amountOff extends AbstractCoupons implements Coupons {

  private float aOffValue;
  private String item;
  private float unitPrice;
  private int quantity;

  public amountOff(int quantity, float unitPrice, String item, float aOffValue) {
    this.aOffValue = aOffValue;
    this.item = item;
    this.unitPrice = unitPrice;
    this.quantity = quantity; if (quantity <= 0 || unitPrice <= 0 || item == "" || item == null || aOffValue <= 0) {
      throw new IllegalArgumentException("Invalid Argument!");
    }
  }

  @Override
  public float finalPrice() {
    float discountPrice = finalPriceHelper(quantity, unitPrice, item, aOffValue);
    return discountPrice;
  }

  public amountOff stackCoupons(Coupons cou) {
    if (cou instanceof amountOff) {
      amountOff that = (amountOff) cou;
      if (this.item == that.item && this.unitPrice == that.unitPrice && this.quantity == that.quantity) {
        that.aOffValue = this.aOffValue + that.aOffValue;
        float newDisc = finalPriceHelper(quantity, unitPrice, item, this.aOffValue + that.aOffValue);
        //System.out.println("/"+newDisc);
        return that;
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
