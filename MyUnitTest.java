import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import java.io.*;

public class MyUnitTest {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }


  @Test
  public void testCreateEggRoll() {
    Roll roll = new EggRoll();

    String type = roll.getType();

    Assertions.assertEquals(type, "egg");
    Assertions.assertEquals(roll.getPrice(), 2.25F);
    Assertions.assertEquals(roll.getBaseRoll(), roll);
  }

  @Test
  public void testCreateJellyRoll() {
    Roll roll = new JellyRoll();

    String type = roll.getType();

    Assertions.assertEquals(type, "jelly");
    Assertions.assertEquals(roll.getPrice(), 3F);
    Assertions.assertEquals(roll.getBaseRoll(), roll);
  }

  @Test
  public void testCreatePastryRoll() {
    Roll roll = new PastryRoll();

    String type = roll.getType();

    Assertions.assertEquals(type, "pastry");
    Assertions.assertEquals(roll.getPrice(), 3.50F);
    Assertions.assertEquals(roll.getBaseRoll(), roll);
  }

  @Test
  public void testCreateSausageRoll() {
    Roll roll = new SausageRoll();

    String type = roll.getType();

    Assertions.assertEquals(type, "sausage");
    Assertions.assertEquals(roll.getPrice(), 4.25F);
    Assertions.assertEquals(roll.getBaseRoll(), roll);
  }

  @Test
  public void testCreateSpringRoll() {
    Roll roll = new SpringRoll();

    String type = roll.getType();

    Assertions.assertEquals(type, "spring");
    Assertions.assertEquals(roll.getPrice(), 1.75F);
    Assertions.assertEquals(roll.getBaseRoll(), roll);
  }

  @Test
  public void testExtraSauce() {
    Roll baseRoll = new SpringRoll();
    Roll roll = new ExtraSauce(baseRoll, 2);

    String type = roll.getType();

    Assertions.assertEquals(type, "spring");
    Assertions.assertEquals(roll.getPrice(), 2.15F);
    Assertions.assertEquals(roll.getBaseRoll(), baseRoll);
  }

  @Test
  public void testExtraTopping() {
    Roll baseRoll = new SpringRoll();
    Roll roll = new ExtraTopping(baseRoll, 4);

    String type = roll.getType();

    Assertions.assertEquals(type, "spring");
    Assertions.assertEquals(roll.getPrice(), 2.15F);
    Assertions.assertEquals(roll.getBaseRoll(), baseRoll);
  }

  @Test
  public void testExtraFilling() {
    Roll baseRoll = new SpringRoll();
    Roll roll = new ExtraFilling(baseRoll, 1);

    String type = roll.getType();

    Assertions.assertEquals(type, "spring");
    Assertions.assertEquals(roll.getPrice(), 2.0F);
    Assertions.assertEquals(roll.getBaseRoll(), baseRoll);
  }

  @Test
  void testRollPrint() {
    Roll roll = new SpringRoll();
    roll.printType();

    String expectedString = "spring";

    Assertions.assertEquals(expectedString, outputStreamCaptor.toString()
            .trim());
  }

  @Test
  void testDeoratedRollPrint() {
    String newLine = System.getProperty("line.separator");
    Roll baseRoll = new SpringRoll();
    Roll roll = new ExtraFilling(baseRoll, 1);
    roll.printType();

    String expectedString = "spring" +
                            newLine +
                            "\t + 1 extra filling";

    Assertions.assertEquals(expectedString, outputStreamCaptor.toString()
            .trim());
  }

}
