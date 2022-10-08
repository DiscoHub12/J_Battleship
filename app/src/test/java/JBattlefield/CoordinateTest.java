package JBattlefield;


import JBattlefield.Model.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {
    /**
     * Test the correct values after call
     * get method for x values.
     */
    @Test
    public void testGetXPoint(){
        int x = 5;
        Coordinate tmp = new Coordinate( x, 12);
        assertEquals(x, tmp.getXPoint());
        int x1 = Integer.MAX_VALUE;
        assertThrows(IllegalArgumentException.class, () -> new Coordinate(x1, 10));
    }

    /**
     * Test the correct values after call
     * set methods whit modify x values.
     */
    @Test
    public void testSetXPoint(){
        Coordinate tmp = new Coordinate(12, 12);
        assertThrows(IllegalArgumentException.class, () -> tmp.setXPoint(Integer.MAX_VALUE));
        tmp.setXPoint(15);
        assertEquals(15, tmp.getXPoint());
        tmp.setXPoint(20);
        assertEquals(20, tmp.getXPoint());

    }

    /**
     * Test the correct values after call
     * get method for y values.
     */
    @Test
    public void testGetYPoint(){
        int y = 12;
        Coordinate tmp = new Coordinate(10, y);
        assertEquals(y, tmp.getYPoint());
        int yM = Integer.MAX_VALUE;
        assertThrows(IllegalArgumentException.class, () -> new Coordinate(10, yM));
    }

    /**
     * Test the correct values after call
     * set methods whit modify y values.
     */
    @Test
    public void testSetYPoint(){
        Coordinate tmp = new Coordinate(12,12);
        assertThrows(IllegalArgumentException.class, () -> tmp.setYPoint(Integer.MAX_VALUE));
        tmp.setYPoint(15);
        assertEquals(15, tmp.getYPoint());
        tmp.setYPoint(20);
        assertEquals(20, tmp.getYPoint());
    }

    /**
     * Test the equals methods.
     */
    @Test
    public void testEquals(){
        Coordinate one = new Coordinate(2,3);
        Coordinate two = new Coordinate(2,3);
        assertEquals(one, two);
        Coordinate three = new Coordinate(4,5);
        assertNotEquals(one, three);
    }
}
