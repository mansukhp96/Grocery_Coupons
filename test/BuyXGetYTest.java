import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuyXGetYTest {

  private BuyXGetY bxgy;

  @Test
  public void testTwoCou() {
    bxgy = new BuyXGetY("Milk", 2, 1);
    assertEquals(27.0f, bxgy.stackCoupons(new BuyXGetY("Milk", 1, 1))
            .finalPrice(3, 10), 0);
  }

  @Test
  public void testOneCou() {
    bxgy = new BuyXGetY("Toy", 3, 2);
    assertEquals(12.0f, bxgy.finalPrice(4, 5), 0);
  }

  @Test
  public void testThreeCou() {
    bxgy = new BuyXGetY("Ball", 5, 2);
    assertEquals(47.5f, bxgy.stackCoupons(new BuyXGetY("Ball", 2, 1))
            .stackCoupons(new BuyXGetY("Ball", 1, 1))
            .finalPrice(2.5f, 20), 0);
  }

  @Test
  public void testTwoCouDiffItem() {
    bxgy = new BuyXGetY("Milk", 2, 1);
    assertEquals(27.0f, bxgy.stackCoupons(new BuyXGetY("Curd", 1, 1))
            .finalPrice(3, 10), 0);
  }

  @Test
  public void testThreeCouTwoSameCou() {
    bxgy = new BuyXGetY("Ball", 1, 1);
    assertEquals(47.5f, bxgy.stackCoupons(new BuyXGetY("bat", 21, 2))
            .stackCoupons(new BuyXGetY("Ball", 10, 2))
            .finalPrice(2.5f, 20), 0);
  }

  @Test
  public void testObj() {
    bxgy = new BuyXGetY("Bread", 10, 2);
    assertEquals("Buy 10 Get 2 on Bread", bxgy.getDescription());
  }

  @Test
  public void testTwoCouDiffItemDesc() {
    bxgy = new BuyXGetY("chocolate", 2, 1);
    assertEquals("Buy 1 Get 1 on chocolate", bxgy.stackCoupons(new BuyXGetY("chocolate", 1, 1))
            .getDescription());
  }

  @Test
  public void testCouWithNullItem() {
    bxgy = new BuyXGetY(null, 1, 1);
    assertEquals("not valid", bxgy.finalPrice(10, 4));
  }

  @Test
  public void testCouWithNegOffp() {
    bxgy = new BuyXGetY("paper", -1, 1);
    assertEquals("Not valiid", bxgy.finalPrice(10, 2));
  }

  @Test
  public void testCouWithZeroOffp() {
    bxgy = new BuyXGetY("book", 0, 1);
    assertEquals("Not valid", bxgy.finalPrice(10, 2));
  }

  @Test
  public void testCouWithZeroUnitP() {
    bxgy = new BuyXGetY("book", 1, 1);
    assertEquals("Not valid", bxgy.finalPrice(0, 2));
  }

  @Test
  public void testCouWithNegUnitP() {
    bxgy = new BuyXGetY("book", 1, 1);
    assertEquals("Not valid", bxgy.finalPrice(-1, 2));
  }

  @Test
  public void testCouWithZeroQua() {
    bxgy = new BuyXGetY("pencil", 10, 2);
    assertEquals("Not valid", bxgy.finalPrice(1, 0));
  }

  @Test
  public void testCouWithNegQua() {
    bxgy = new BuyXGetY("eraser", 11, 3);
    assertEquals("Not valid", bxgy.finalPrice(1, -12));
  }

  @Test
  public void testRidCou() {
    bxgy = new BuyXGetY("box", 999999, 1);
    assertEquals(979.0f, bxgy.finalPrice(89, 12), 0);
  }

  @Test
  public void testDifferentCou() {
    AmountOff amt;
    amt = new AmountOff("tile", 12);
    bxgy = new BuyXGetY("tile", 1, 1);
    assertEquals("Not valid", amt.stackCoupons(bxgy).finalPrice(3, 5));
  }

  @Test
  public void testDifferentCouPer() {
    PercentOff perc;
    perc = new PercentOff("tile", 12);
    bxgy = new BuyXGetY("tile", 12,3);
    assertEquals("Not valid", perc.stackCoupons(bxgy).finalPrice(3, 5));
  }
}