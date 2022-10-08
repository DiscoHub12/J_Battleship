package JBattlefield;

import JBattlefield.Model.RGBColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RGBColorTest {

    /**
     * Test the illegal value.
     */
    @Test
    public void checkIllegalValue() {
        assertThrows(IllegalArgumentException.class, () -> new RGBColor(-1, 256, 257));
        RGBColor tmp = new RGBColor(200, 200, 200);
        assertThrows(IllegalArgumentException.class, () -> tmp.setFirstByte(256));
        assertThrows(IllegalArgumentException.class, () -> tmp.setSecondByte(300));
        assertThrows(IllegalArgumentException.class, () -> tmp.setThirdByte(-1));
    }

    /**
     * Test the correct values after call
     * get method for the first byte of this color.
     */
    @Test
    public void testFirstByteColor() {
        int f = 120;
        RGBColor tmp = new RGBColor(f, 200, 240);
        assertEquals(f, tmp.getFirstByte());
        int f1 = 344;
        assertThrows(IllegalArgumentException.class, () -> new RGBColor(f1, 200, 200));
    }

    /**
     * Test the correct values after call
     * set methods for the first byte of this color
     */
    @Test
    public void testSetFirstByte() {
        RGBColor tmp = new RGBColor(200, 200, 200);
        assertThrows(IllegalArgumentException.class, () -> tmp.setFirstByte(-1));
        assertThrows(IllegalArgumentException.class, () -> tmp.setFirstByte(256));
        tmp.setFirstByte(190);
        assertEquals(190, tmp.getFirstByte());
    }

    /**
     * Test the correct values after call
     * get method for the second  byte of this color.
     */
    @Test
    public void testSecondByteColor() {
        int f = 98;
        RGBColor tmp = new RGBColor(100, f, 200);
        assertEquals(f, tmp.getSecondByte());
        int f1 = 256;
        assertThrows(IllegalArgumentException.class, () -> new RGBColor(100, f1, 200));
    }

    /**
     * Test the correct values after call
     * set methods for the second byte of this color
     */
    @Test
    public void testSetSecondByte() {
        RGBColor tmp = new RGBColor(200, 200, 200);
        assertThrows(IllegalArgumentException.class, () -> tmp.setSecondByte(-1));
        assertThrows(IllegalArgumentException.class, () -> tmp.setSecondByte(256));
        tmp.setSecondByte(232);
        assertEquals(232, tmp.getSecondByte());
    }

    /**
     * Test the correct values after call
     * get method for the third byte of this color.
     */
    @Test
    public void testThirdByteColor() {
        int f = 90;
        RGBColor tmp = new RGBColor(100, 100, f);
        assertEquals(f, tmp.getThirdByte());
        int f1 = 256;
        assertThrows(IllegalArgumentException.class, () -> new RGBColor(100, 100, f1));
    }

    /**
     * Test the correct values after call
     * set methods for the third byte of this color
     */
    @Test
    public void testSetThirdByte() {
        RGBColor tmp = new RGBColor(200, 200, 200);
        assertThrows(IllegalArgumentException.class, () -> tmp.setThirdByte(-1));
        assertThrows(IllegalArgumentException.class, () -> tmp.setThirdByte(256));
        tmp.setThirdByte(123);
        assertEquals(123, tmp.getThirdByte());
    }

    /**
     * Test the equals method.
     */
    @Test
    public void testEquals() {
        RGBColor tmp = new RGBColor(234, 234, 234);
        RGBColor eq = new RGBColor(234, 234, 234);
        assertEquals(tmp, eq);
        RGBColor f = new RGBColor(234, 234, 235);
        assertNotEquals(tmp, f);
    }

}
