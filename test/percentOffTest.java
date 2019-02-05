//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class percentOffTest {
//
//  private percentOff perc;
//
//  @Test
//  public void testPercentOff() {
//    perc = new percentOff(10, 1, "Milk", 2);
//    assertEquals(9.6f, perc.stackCoupons(new percentOff(10, 1, "yo", 2)).finalPrice(), 0);
//  }
//
//  @Test
//  public void testPercentOffDesc() {
//    perc = new percentOff(10, 1, "Eggs", 2);
//    assertEquals("4.0% off on Eggs", perc.stackCoupons(new percentOff(10, 1, "Eggs", 2)).getDescription());
//  }
//}