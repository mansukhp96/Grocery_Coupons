public class buyXGetY extends AbstractCoupons implements Coupons {

  private String item;
  private int x;
  private int y;

  public buyXGetY(String item, int x, int y) {
    this.item = item;
    this.x = x;
    this.y = y;
    if (item == "" || item == null || x <= 0 || y <= 0) {
      throw new IllegalArgumentException("Invalid Argument!");
    }
  }

  @Override
  public buyXGetY stackCoupons(Coupons cou) {
    return this;
  }

  @Override
  public float finalPrice(float unitPrice, float quantity) {
    float discountPrice = (quantity - y) * unitPrice;
    return discountPrice;
  }

  @Override
  public String toString() {
    return "Buy " + x + " Get " + y + " on " + item;
  }

  public static void main(String[] args) {
    buyXGetY b = new buyXGetY("toy", 1, 1);
    System.out.println(b.finalPrice(2, 8));
  }
}