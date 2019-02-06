public class BuyXGetY extends AbstractCoupons implements Coupons {

  private String item;
  private int x;
  private int y;

  /**
   * Constructor to create an object of buyXgetY type coupon.
   *
   * @param item is the item name.
   * @param x    is the BUY X.
   * @param y    is the number of items you get.
   * @throws IllegalArgumentException when the item is null or x and y are less than or equal to 0.
   */

  public BuyXGetY(String item, int x, int y) {
    this.item = item;
    this.x = x;
    this.y = y;
    if (item == null || x <= 0 || y <= 0) {
      throw new IllegalArgumentException("Invalid Argument!");
    }
  }

  /**
   * This method stacks coupons of this type and for same item.
   *
   * @param cou is the coupon to be stacked to the other coupon.
   * @return a new coupon object that is of buyxgety type with the better ratio coupon.
   */

  @Override
  public BuyXGetY stackCoupons(Coupons cou) {
    if (cou instanceof BuyXGetY) {
      BuyXGetY that = (BuyXGetY) cou;
      if (this.item == that.item) {
        int a = this.x / this.y;
        int b = that.x / that.y;
        if (a >= b) {
          BuyXGetY bxy = new BuyXGetY(that.item, that.x, that.y);
          return bxy;
        }
      }
    }
    return this;
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
    if (unitPrice <= 0 || quantity <= 0) {
      throw new IllegalArgumentException("Invalid Initial price/quantity");
    } else {
      float discountPrice = (quantity - y) * unitPrice;
      return discountPrice;
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
    return "Buy " + x + " Get " + y + " on " + item;
  }
}