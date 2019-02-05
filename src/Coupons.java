public interface Coupons {

  float finalPrice(float unitPrice, float quantity);

  Coupons stackCoupons(Coupons cou);

  String getDescription();
}