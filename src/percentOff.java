public class percentOff extends AbstractCoupons implements Coupons {

  private float pOffValue;
  private String item;

  public percentOff(String item, float pOffValue) {
    this.pOffValue = pOffValue;
    this.item = item;
    if (item == "" || item == null || pOffValue <= 0) {
      throw new IllegalArgumentException("Invalid Argument!");
    }
  }

  @Override
  public float finalPrice(float unitPrice, float quantity) {
    float totalPrice = unitPrice * quantity;
    float discountPrice = (totalPrice - (pOffValue / 100) * totalPrice);
    return discountPrice;
  }

  public percentOff stackCoupons(Coupons cou) {
    if (cou instanceof percentOff) {
      percentOff that = (percentOff) cou;
      if (this.item == that.item) {
        percentOff per = new percentOff(item, this.pOffValue + that.pOffValue);
        return per;
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
    return pOffValue + "% off on " + item;
  }

  public static void main(String[] args) {
    percentOff n = new percentOff("eggs", 10);
    percentOff n2 = new percentOff("eggs", 10);
    System.out.println(n.stackCoupons(n2).finalPrice(2,2));
  }
}