public class AmountOff extends AbstractCoupons implements Coupons {

  private float aOffValue;
  private String item;

  /**
   * This constructor creates an object of this type.
   *
   * @param item      is the name of the item.
   * @param aOffValue is the amount off the coupon will be giving on the item.
   * @throws IllegalArgumentException when the off amount is zero or below 0 or item name is null.
   */

  public AmountOff(String item, float aOffValue) {
    this.aOffValue = aOffValue;
    this.item = item;
    if (item == null || aOffValue <= 0) {
      throw new IllegalArgumentException("Invalid Argument!");
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
  public float finalPrice(float unitPrice, float quantity) {
    float totalPrice = unitPrice * quantity;
    float discountPrice = (totalPrice - aOffValue);
    if (discountPrice <= 0) {
      throw new IllegalArgumentException("Discount cant go below zero!");
    }
    return discountPrice;
  }

  /**
   * This method stacks coupons of this type and for same item.
   *
   * @param cou is the coupon to be stacked to the other coupon.
   * @return a new coupon object that is of percent off type with the stacked discounts.
   */

  public AmountOff stackCoupons(Coupons cou) {
    if (cou instanceof AmountOff) {
      AmountOff that = (AmountOff) cou;
      if (this.item == that.item) {
        AmountOff amt = new AmountOff(that.item, this.aOffValue + that.aOffValue);
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