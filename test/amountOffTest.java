import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class amountOffTest {

  private amountOff perc;

  @Test
  public void testAmountOff() {
    perc = new amountOff(10, 1, "Sweets", 2);
    assertEquals(6.0f, perc.stackCoupons(new amountOff(10, 1, "Sweets", 2)).finalPrice(), 0);
  }

  @Test
  public void testAmountOffDesc() {
    perc = new amountOff(10, 1, "Eggs", 2);
    assertEquals("$4.0 off on Eggs", perc.stackCoupons(new amountOff(10, 1, "Eggs", 2)).getDescription());
  }
}