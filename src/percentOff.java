public class PercentOff extends AbstractCoupons implements Coupons {

  private float pOffValue;
  private String item;

  /**
   * This constructor creates an object of this type.
   *
   * @param item      is the name of the item.
   * @param pOffValue is the percentage off the coupon will be giving on the item.
   * @throws IllegalArgumentException when the off percentage is zero or below 0 or item name is
   *                                  null.
   */

  public PercentOff(String item, float pOffValue) throws IllegalArgumentException {
    this.pOffValue = pOffValue;
    this.item = item;
    if (item == null || pOffValue <= 0) {
      throw new IllegalArgumentException("Invalid Coupon offValue/item");
    }
  }

  /**
   * This method calculates the final price the customer needs to pay after discount.
   *
   * @param unitPrice is the price per unit quantity of an item.
   * @param quantity  is the number of items to be bought.
   * @return it returns the final price to be paid by the customer.
   */

  @Override
  public float finalPrice(float unitPrice, float quantity) throws IllegalArgumentException {
    if (unitPrice <= 0 || quantity <= 0) {
      throw new IllegalArgumentException("Invalid Initial price/quantity");
    } else {
      float totalPrice = unitPrice * quantity;
      if ((totalPrice - (pOffValue / 100) * totalPrice) <= 0) {
        throw new IllegalArgumentException("Discount cannot go below zero!");
      }
      return (totalPrice - (pOffValue / 100) * totalPrice);
    }
  }

  /**
   * This method stacks coupons of this type and for same item.
   *
   * @param cou is the coupon to be stacked to the other coupon.
   * @return a new coupon object that is of percent off type with the stacked discounts.
   */

  public PercentOff stackCoupons(Coupons cou) throws IllegalArgumentException {
    if (cou instanceof PercentOff) {
      PercentOff that = (PercentOff) cou;
      if (this.item == that.item) {
        PercentOff per = new PercentOff(item, this.pOffValue + that.pOffValue);
        return per;
      } else {
        throw new IllegalArgumentException("Not Stackable!");
      }
    } else {
      throw new IllegalArgumentException("Not Stackable!");
    }
  }

  /**
   * This method is used for getting the description of the coupon.
   *
   * @return the accumulated discount descritiopn of the coupon.
   */


  @Override
  public String getDescription() {
    return super.getDescription();
  }

  @Override
  public String toString() {
    return pOffValue + "% off on " + item;
  }
}