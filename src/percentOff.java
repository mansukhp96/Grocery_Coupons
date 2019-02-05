public class percentOff extends AbstractCoupons implements Coupons {

  private float pOffValue;
  private String item;
  private float unitPrice;
  private int quantity;

  public percentOff(int quantity, float unitPrice, String item, float pOffValue) {
    this.pOffValue = pOffValue;
    this.item = item;
    this.quantity = quantity;
    this.unitPrice = unitPrice; //need to add exceptions to handle invalid parameters
    if (quantity <= 0 || unitPrice <= 0 || item == "" || item == null || pOffValue <= 0) {
      throw new IllegalArgumentException("Invalid Argument!");
    }
  }

  public percentOff stackCoupons(percentOff cou) {
    if (cou instanceof percentOff) {
      if (this.item == cou.item && this.unitPrice == cou.unitPrice && this.quantity == cou.quantity) {
        cou.pOffValue = this.pOffValue + cou.pOffValue;
        float newDisc = finalPriceHelper(quantity, unitPrice, item, this.pOffValue + cou.pOffValue);
        //System.out.println("/"+newDisc);
        return cou;
      } else {
        throw new IllegalArgumentException("Not Stackable!");
      }
    } else {
      throw new IllegalArgumentException("Not Stackable!");
    }
  }

  @Override
  public float finalPrice() {
    float discountPrice = finalPriceHelper(quantity, unitPrice, item, pOffValue);
    return discountPrice;
  }

  private float finalPriceHelper(int quantity, float unitPrice, String item, float pOffValue) {
    float totalPrice = unitPrice * quantity;
    float discountPrice = (totalPrice - (pOffValue / 100) * totalPrice);
    return discountPrice;
  }

  @Override
  public String getDescription() {
    return super.getDescription();
  }

  @Override
  public String toString() {
    String str = pOffValue + "% off on " + item;
    return str;
  }
}