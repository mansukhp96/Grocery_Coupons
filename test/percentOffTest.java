import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PercentOffTest {

  private PercentOff perc;

  @Test
  public void testTwoCou() {
    perc = new PercentOff("Milk", 2);
    assertEquals(29.1f, perc.stackCoupons(new PercentOff("Milk", 1))
            .finalPrice(3, 10), 0);
  }

  @Test
  public void testOneCou() {
    perc = new PercentOff("Toy", 3);
    assertEquals(19.4f, perc.finalPrice(4, 5), 0);
  }

  @Test
  public void testThreeCou() {
    perc = new PercentOff("Ball", 5);
    assertEquals(46.0f, perc.stackCoupons(new PercentOff("Ball", 2))
            .stackCoupons(new PercentOff("Ball", 1))
            .finalPrice(2.5f, 20), 0);
  }

  @Test
  public void testTwoCouDiffItem() {
    perc = new PercentOff("Milk", 2);
    assertEquals(29.1f, perc.stackCoupons(new PercentOff("Curd", 1))
            .finalPrice(3, 10), 0);
  }

  @Test
  public void testThreeCouTwoSameCou() {
    perc = new PercentOff("Ball", 1);
    assertEquals(46.0f, perc.stackCoupons(new PercentOff("bat", 21))
            .stackCoupons(new PercentOff("Ball", 10))
            .finalPrice(2.5f, 20), 0);
  }

  @Test
  public void testObj() {
    perc = new PercentOff("Bread", 10);
    assertEquals("10.0% off on Bread", perc.getDescription());
  }

  @Test
  public void testTwoCouDiffItemDesc() {
    perc = new PercentOff("chocolate", 2);
    assertEquals("3.0% off on chocolate", perc.stackCoupons(new PercentOff("chocolate", 1))
            .getDescription());
  }

  @Test
  public void testCouWithNullItem() {
    perc = new PercentOff(null, 1);
    assertEquals("not valid", perc.finalPrice(10, 4));
  }

  @Test
  public void testCouWithEmptyItem() {
    perc = new PercentOff("", 1);
    assertEquals("not valid", perc.finalPrice(10, 4));
  }

  @Test
  public void testCouWithNegOffp() {
    perc = new PercentOff("paper", -1);
    assertEquals("Not valiid", perc.finalPrice(10, 2));
  }

  @Test
  public void testCouWithZeroOffp() {
    perc = new PercentOff("book", 0);
    assertEquals("Not valid", perc.finalPrice(10, 2));
  }

  @Test
  public void testCouWithZeroUnitP() {
    perc = new PercentOff("book", 1);
    assertEquals("Not valid", perc.finalPrice(0, 2));
  }

  @Test
  public void testCouWithNegUnitP() {
    perc = new PercentOff("book", 1);
    assertEquals("Not valid", perc.finalPrice(-1, 2));
  }

  @Test
  public void testCouWithZeroQua() {
    perc = new PercentOff("pencil", 10);
    assertEquals("Not valid", perc.finalPrice(1, 0));
  }

  @Test
  public void testCouWithNegQua() {
    perc = new PercentOff("eraser", 11);
    assertEquals("Not valid", perc.finalPrice(1, -12));
  }

  @Test
  public void testRidCou() {
    perc = new PercentOff("box", 999999);
    assertEquals("Not valid", perc.finalPrice(89, 12));
  }

  @Test
  public void testDifferentCou() {
    AmountOff amt;
    amt = new AmountOff("tile", 12);
    perc = new PercentOff("tile", 1);
    assertEquals("Not valid", amt.stackCoupons(perc).finalPrice(3, 5));
  }
}