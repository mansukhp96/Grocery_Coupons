import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class percentOffTest {

  private percentOff perc;

  @Test
  public void testPercentOff() {
    perc = new percentOff(10,2, "bread", 2);
    assertEquals("1", perc.finalPrice());
  }

  @Test
  public void testPercentOffDesc() {
    perc = new percentOff(5, 2, "eggs", 5);
    assertEquals("5.0% off on eggs", perc.getDescription());
  }
}