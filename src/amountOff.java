public class amountOff extends AbstractCoupons implements Coupons {

  private float aOffValue;
  private String item;

  public amountOff(String item, float aOffValue) {
    this.aOffValue = aOffValue;
    this.item = item;
    if (item == "" || item == null || aOffValue <= 0) {
      throw new IllegalArgumentException("Invalid Argument!");
    }
  }

  @Override
  public float finalPrice(float unitPrice, float quantity) {
    float totalPrice = unitPrice * quantity;
    float discountPrice = (totalPrice - aOffValue);
    return discountPrice;
  }

  public amountOff stackCoupons(Coupons cou) {
    if (cou instanceof amountOff) {
      amountOff that = (amountOff) cou;
      if (this.item == that.item) {
        amountOff amt = new amountOff(that.item, this.aOffValue + that.aOffValue);
        return amt;
      } else {
        throw new IllegalArgumentException("Not Stackable!");
      }
    } else {
      throw new IllegalArgumentException("Not Stackable!");
    }
  }

  @Override
  public String getDescription() {
    return super.getDescription();
  }

  @Override
  public String toString() {
    return "$" + aOffValue + " off on " + item;
  }
}