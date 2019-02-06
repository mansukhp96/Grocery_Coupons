/**
 * <p>
 * This interface represents a set of operations on grocery coupons. There are three kinds of
 * coupons. They apply on specific items. AmountOff, PercentOff and BuyXGetY are three coupons that
 * are offered with different ways of discount operations explained in each of the class.
 *
 * AmountOff coupon, provides a certain value off on an item for a given quantity. Also, gives a way
 * to get the description of the coupon and the final price after all discounts.
 *
 * PercentOff coupon, provides a certain percent off on a item for a given quantity. Also, gives a
 * way to get the description of the coupon and the final price after all discounts.
 *
 * BuyXGetY coupon, provides a way to get certain number of same items (Y) when you buy a certain
 * (X) number of items. Also, provides a way to get the description of the coupon and the final
 * price after all discounts. Here, multiple coupons are compared and the one with the least ratio
 * is chosen (buy X get Y then, x/y is done is get the ratio and decide the coupon.)
 * </p>
 */

public interface Coupons {
  /**
   * This method calculates the final price to be paid by the customer.
   *
   * @param unitPrice is the price per unit quantity of an item.
   * @param quantity  is the number of items to be bought.
   * @return the final price to be paid by the customer  after applying all the discounts.
   * @throws IllegalArgumentException when the unit price or the quantity is zero or is below zero.
   */
  float finalPrice(float unitPrice, float quantity) throws IllegalArgumentException;

  /**
   * This method stacks coupons of the same type and throws exceptions when they are of different
   * types or have different item names.
   *
   * @param cou is the coupon to be stacked to the other coupon.
   * @return the new coupon with the discount accumulated.
   * @throws IllegalArgumentException when two or more coupons of different types are going to be
   *                                  stacked or same type of coupons that are for different items.
   */
  Coupons stackCoupons(Coupons cou) throws IllegalArgumentException;

  /**
   * This method is to obtain the description of the coupon.
   *
   * @return toString() to get what the coupon is. It also shows the total stacked discount.
   */

  String getDescription();
}