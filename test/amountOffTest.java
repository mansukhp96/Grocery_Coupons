import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AmountOffTest {

  private AmountOff amt;

  @Test
  public void testTwoCou() {
    amt = new AmountOff("Milk", 2);
    assertEquals(27.0f, amt.stackCoupons(new AmountOff("Milk", 1))
            .finalPrice(3, 10), 0);
  }

  @Test
  public void testOneCou() {
    amt = new AmountOff("Toy", 3);
    assertEquals(17.0f, amt.finalPrice(4, 5), 0);
  }

  @Test
  public void testThreeCou() {
    amt = new AmountOff("Ball", 5);
    assertEquals(42.0f, amt.stackCoupons(new AmountOff("Ball", 2))
            .stackCoupons(new AmountOff("Ball", 1))
            .finalPrice(2.5f, 20), 0);
  }

  @Test
  public void testTwoCouDiffItem() {
    amt = new AmountOff("Milk", 2);
    assertEquals(29.1f, amt.stackCoupons(new AmountOff("Curd", 1))
            .finalPrice(3, 10), 0);
  }

  @Test
  public void testThreeCouTwoSameCou() {
    amt = new AmountOff("Ball", 1);
    assertEquals(46.0f, amt.stackCoupons(new AmountOff("bat", 21))
            .stackCoupons(new AmountOff("Ball", 10))
            .finalPrice(2.5f, 20), 0);
  }

  @Test
  public void testObj() {
    amt = new AmountOff("Bread", 10);
    assertEquals("$10.0 off on Bread", amt.getDescription());
  }

  @Test
  public void testTwoCouDiffItemDesc() {
    amt = new AmountOff("chocolate", 2);
    assertEquals("$3.0 off on chocolate", amt.stackCoupons(new AmountOff("chocolate", 1))
            .getDescription());
  }

  @Test
  public void testCouWithNullItem() {
    amt = new AmountOff(null, 1);
    assertEquals("not valid", amt.finalPrice(10, 4));
  }

  @Test
  public void testCouWithEmptyItem() {
    amt = new AmountOff("", 1);
    assertEquals("not valid", amt.finalPrice(10, 4));
  }

  @Test
  public void testCouWithNegOffp() {
    amt = new AmountOff("paper", -1);
    assertEquals("Not valiid", amt.finalPrice(10, 2));
  }

  @Test
  public void testCouWithZeroOffp() {
    amt = new AmountOff("book", 0);
    assertEquals("Not valid", amt.finalPrice(10, 2));
  }

  @Test
  public void testCouWithZeroUnitP() {
    amt = new AmountOff("book", 1);
    assertEquals("Not valid", amt.finalPrice(0, 2));
  }

  @Test
  public void testCouWithNegUnitP() {
    amt = new AmountOff("book", 1);
    assertEquals("Not valid", amt.finalPrice(-1, 2));
  }

  @Test
  public void testCouWithZeroQua() {
    amt = new AmountOff("pencil", 10);
    assertEquals("Not valid", amt.finalPrice(1, 0));
  }

  @Test
  public void testCouWithNegQua() {
    amt = new AmountOff("eraser", 11);
    assertEquals("Not valid", amt.finalPrice(1, -12));
  }

  @Test
  public void testRidCou() {
    amt = new AmountOff("box", 999999);
    assertEquals("Not valid", amt.finalPrice(89, 12));
  }

  @Test
  public void testDifferentCou() {
    PercentOff perct;
    amt = new AmountOff("tile", 12);
    perct = new PercentOff("tile", 1);
    assertEquals("Not valid", amt.stackCoupons(perct).finalPrice(3, 5));
  }

  @Test
  public void testDifferentCouBygx() {
    BuyXGetY bygx;
    amt = new AmountOff("tile", 12);
    bygx = new BuyXGetY("tile", 1,1);
    assertEquals("Not valid", amt.stackCoupons(bygx).finalPrice(3, 5));
  }
}