public abstract class AbstractCoupons implements Coupons {

  /**
   * This method calculates the final price to be paid by the customer.
   *
   * @param unitPrice is the price per unit quantity of an item.
   * @param quantity  is the number of items to be bought.
   * @return the final price to be paid by the customer  after applying all the discounts.
   * @throws IllegalArgumentException when the unit price or the quantity is zero or is below zero.
   */
  @Override
  public abstract float finalPrice(float unitPrice, float quantity);

  /**
   * This method stacks coupons of the same type and throws exceptions when they are of different
   * types or have different item names.
   *
   * @param cou is the coupon to be stacked to the other coupon.
   * @return the new coupon with the discount accumulated.
   * @throws IllegalArgumentException when two or more coupons of different types are going to be
   *                                  stacked or same type of coupons that are for different items.
   */

  @Override
  public abstract Coupons stackCoupons(Coupons cou);

  /**
   * This method is to obtain the description of the coupon.
   *
   * @return toString() to get what the coupon is. It also shows the total stacked discount.
   */

  @Override
  public String getDescription() {
    return toString();
  }
}