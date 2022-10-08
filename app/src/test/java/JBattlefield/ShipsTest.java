package JBattlefield;

import JBattlefield.Model.Coordinate;
import JBattlefield.Model.Ship;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShipsTest {

    private final Coordinate tmp = new Coordinate(5, 5);

    /**
     * Test the Illegal value passing for
     * create a Ship.
     */
    @Test
    public void testIllegalValue() {
        assertThrows(NullPointerException.class, () -> new Ship(null, 2, 2));
        assertThrows(IllegalArgumentException.class, () -> new Ship(tmp, 5, 2));
    }

    /**
     * Test the correct get method that return the
     * length of the Ship.
     */
    @Test
    public void testGetLength() {
        Ship one = new Ship(tmp, 2, 1);
        assertEquals(1, one.getLength());
        Ship two = new Ship(tmp, 2, 2);
        assertEquals(2, two.getLength());
        Ship three = new Ship(tmp, 2, 3);
        assertEquals(3, three.getLength());
    }

    /**
     * Test the correct get method that return the
     * direction of the Ship.
     */
    @Test
    public void testGetDirection() {
        Ship one = new Ship(tmp, 1, 1);
        assertEquals(1, one.getDirection());
        Ship two = new Ship(tmp, 2, 2);
        assertEquals(2, two.getDirection());
        Ship three = new Ship(tmp, 3, 3);
        assertEquals(3, three.getDirection());
    }

    /**
     * Test the set method to set another direction
     * for the Ship.
     */
    @Test
    public void testSetDirection() {
        Ship one = new Ship(tmp, 1, 2);
        assertEquals(1, one.getDirection());
        one.setDirection(2);
        assertEquals(2, one.getDirection());
        one.setDirection(3);
        assertEquals(3, one.getDirection());
        one.setDirection(4);
        assertEquals(4, one.getDirection());
        assertThrows(IllegalArgumentException.class, () -> one.setDirection(5));
        assertThrows(IllegalArgumentException.class, () -> one.setDirection(-1));
    }

    /**
     * Test the correct get method to return
     * the Start position (Coordinate) of
     * the Ship.
     */
    @Test
    public void testGetStartPosition() {
        Ship one = new Ship(tmp, 2, 2);
        assertEquals(tmp, one.getStart());
        Coordinate c1 = new Coordinate(4, 4);
        one = new Ship(c1, 2, 2);
        assertEquals(c1, one.getStart());
        Coordinate c2 = new Coordinate(3, 3);
        one = new Ship(c2, 2, 2);
        assertEquals(c2, one.getStart());
    }

    /**
     * Test the correct set method to set
     * another start position of this Ship.
     */
    @Test
    public void testSetStartPosition() {
        Ship one = new Ship(tmp, 2, 2);
        Coordinate c1 = new Coordinate(4, 4);
        one.setStartCoordinate(c1);
        assertEquals(c1, one.getStart());
        Coordinate c2 = new Coordinate(3, 3);
        one.setStartCoordinate(c2);
        assertEquals(c2, one.getStart());
        assertThrows(NullPointerException.class, () -> one.setStartCoordinate(null));
    }

    /**
     * Test the get method to return the
     * end position of the Ship.
     */
    @Test
    public void testGetEndPosition() {
        Ship one = new Ship(tmp, 2, 2);
        assertEquals(5, one.getEnd().getXPoint());
        assertEquals(6, one.getEnd().getYPoint());
        Coordinate c1 = new Coordinate(4, 4);
        one.setStartCoordinate(c1);
        one.setDirection(1);
        assertEquals(5, one.getEnd().getXPoint());
        assertEquals(4, one.getEnd().getYPoint());
        Coordinate c2 = new Coordinate(3, 3);
        one.setStartCoordinate(c2);
        one.setDirection(3);


    }

    /**
     * Test method that checks the correct Coordinates
     * occupied by a Ship based on its starting position (Coordinate)
     * direction and length.
     */
    @Test
    public void testGetAllShipPosition() {
        Ship one = new Ship(tmp, 1, 3);
        assertEquals(5, one.allShipPosition()[0].getXPoint());
        assertEquals(5, one.allShipPosition()[0].getYPoint());
        assertEquals(6, one.allShipPosition()[1].getXPoint());
        assertEquals(5, one.allShipPosition()[1].getYPoint());
        assertEquals(7, one.allShipPosition()[2].getXPoint());
        assertEquals(5, one.allShipPosition()[2].getYPoint());
        Ship two = new Ship(tmp, 2, 3);
        assertEquals(5, two.allShipPosition()[0].getXPoint());
        assertEquals(5, two.allShipPosition()[0].getYPoint());
        assertEquals(5, two.allShipPosition()[1].getXPoint());
        assertEquals(6, two.allShipPosition()[1].getYPoint());
        assertEquals(5, two.allShipPosition()[2].getXPoint());
        assertEquals(7, two.allShipPosition()[2].getYPoint());
        Ship three = new Ship(tmp, 3, 3);
        assertEquals(5, three.allShipPosition()[0].getXPoint());
        assertEquals(5, three.allShipPosition()[0].getYPoint());
        assertEquals(4, three.allShipPosition()[1].getXPoint());
        assertEquals(5, three.allShipPosition()[1].getYPoint());
        assertEquals(3, three.allShipPosition()[2].getXPoint());
        assertEquals(5, three.allShipPosition()[2].getYPoint());
        Ship four = new Ship(tmp, 4, 3);
        assertEquals(5, four.allShipPosition()[0].getXPoint());
        assertEquals(5, four.allShipPosition()[0].getYPoint());
        assertEquals(5, four.allShipPosition()[1].getXPoint());
        assertEquals(4, four.allShipPosition()[1].getYPoint());
        assertEquals(5, four.allShipPosition()[2].getXPoint());
        assertEquals(3, four.allShipPosition()[2].getYPoint());
    }

    /**
     * Test method that checks the correct Coordinates
     * assigned to the Coordinate array occupied by the Ship.
     */
    @Test
    public void testApplyShipCoordinate() {
        Ship one = new Ship(tmp, 1, 3);
        assertEquals(5, one.allShipPosition()[0].getXPoint());
        assertEquals(5, one.allShipPosition()[0].getYPoint());
        assertEquals(6, one.allShipPosition()[1].getXPoint());
        assertEquals(5, one.allShipPosition()[1].getYPoint());
        assertEquals(7, one.allShipPosition()[2].getXPoint());
        assertEquals(5, one.allShipPosition()[2].getYPoint());
        Ship two = new Ship(tmp, 2, 3);
        assertEquals(5, two.allShipPosition()[0].getXPoint());
        assertEquals(5, two.allShipPosition()[0].getYPoint());
        assertEquals(5, two.allShipPosition()[1].getXPoint());
        assertEquals(6, two.allShipPosition()[1].getYPoint());
        assertEquals(5, two.allShipPosition()[2].getXPoint());
        assertEquals(7, two.allShipPosition()[2].getYPoint());
        Ship three = new Ship(tmp, 3, 3);
        assertEquals(5, three.allShipPosition()[0].getXPoint());
        assertEquals(5, three.allShipPosition()[0].getYPoint());
        assertEquals(4, three.allShipPosition()[1].getXPoint());
        assertEquals(5, three.allShipPosition()[1].getYPoint());
        assertEquals(3, three.allShipPosition()[2].getXPoint());
        assertEquals(5, three.allShipPosition()[2].getYPoint());
        Ship four = new Ship(tmp, 4, 3);
        assertEquals(5, four.allShipPosition()[0].getXPoint());
        assertEquals(5, four.allShipPosition()[0].getYPoint());
        assertEquals(5, four.allShipPosition()[1].getXPoint());
        assertEquals(4, four.allShipPosition()[1].getYPoint());
        assertEquals(5, four.allShipPosition()[2].getXPoint());
        assertEquals(3, four.allShipPosition()[2].getYPoint());
    }

}
