public interface Coupons {

  float finalPrice();

  Coupons stackCoupons(Coupons cou);

  String getDescription();
}