package JBattlefield;


import JBattlefield.Model.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class BattlefieldTest {

    private final Ship s1 = new Ship(new Coordinate(5,5), 1, 3);
    private final Ship s2 = new Ship(new Coordinate(12,7),2,4);
    private final Ship s3 = new Ship(new Coordinate(16,4), 2,3);
    private final Ship s4 = new Ship(new Coordinate(4,13), 4,4);
    private final Ship s5 = new Ship(new Coordinate(10,17), 2,2);
    private final Ship s6 = new Ship(new Coordinate(13,13), 3,4);
    private final Set<Ship> ships = new HashSet<>();

    private final RGBColor color = new RGBColor(0,0,0);
    public void addShips(){
        Collections.addAll(ships, s1,s2,s3,s4,s5,s6);
    }


    /**
     * This method tests the null parameters
     * if they are passed to the constructor of Battlefield.
     */
    @Test
    public void testNullParameters() {
        assertThrows(NullPointerException.class, () -> new Battlefield(20, null, color));
        assertThrows(NullPointerException.class, () -> new Battlefield(20, ships, null));
    }

    /**
     * This metod tests the correct functioning of
     * returning the Base and Heigth of the Battlefield.
     */
    @Test
    public void testGetBase() {
        Battlefield battle = new Battlefield(20, ships, color);
        addShips();
        assertEquals(20, battle.getBaseHeight());
        battle = new Battlefield(30, ships, color);
        assertEquals(30, battle.getBaseHeight());
        battle = new Battlefield(22, ships, color);
        assertEquals(22, battle.getBaseHeight());
    }

    /**
     * This method tests the proper functioning of the
     * Battlefield RGBColor return.
     */
    @Test
    public void testGetColorArea() {
        Battlefield battle = new Battlefield(20, ships, color);
        addShips();
        assertEquals(0, battle.getColorArea().getFirstByte());
        assertEquals(0, battle.getColorArea().getSecondByte());
        assertEquals(0, battle.getColorArea().getThirdByte());
        battle = new Battlefield(20, ships, new RGBColor(23, 24, 25));
        addShips();
        assertEquals(23, battle.getColorArea().getFirstByte());
        assertEquals(24, battle.getColorArea().getSecondByte());
        assertEquals(25, battle.getColorArea().getThirdByte());
        battle = new Battlefield(20, ships, new RGBColor(243, 244, 245));
        addShips();
        assertEquals(243, battle.getColorArea().getFirstByte());
        assertEquals(244, battle.getColorArea().getSecondByte());
        assertEquals(245, battle.getColorArea().getThirdByte());
    }

    /**
     * This method tests the proper functioning of
     * setting a new color of the Battlefield.
     */
    @Test
    public void testSetColorArea() {
        Battlefield battle = new Battlefield(20, ships, color);
        addShips();
        battle.setColorArea(new RGBColor(23, 23, 23));
        assertEquals(23, battle.getColorArea().getFirstByte());
        assertEquals(23, battle.getColorArea().getSecondByte());
        assertEquals(23, battle.getColorArea().getThirdByte());
        battle.setColorArea(new RGBColor(12, 13, 14));
        assertEquals(12, battle.getColorArea().getFirstByte());
        assertEquals(13, battle.getColorArea().getSecondByte());
        assertEquals(14, battle.getColorArea().getThirdByte());
    }

    /**
     * This method tests the correct functioning of the
     * method which checks whether certain Coordinates
     * are within the Battlefield of not.
     */
    @Test
    public void testCoordinateInside() {
        Battlefield battle = new Battlefield(20, ships, color);
        addShips();
        Coordinate c1 = new Coordinate(5, 5);
        assertTrue(battle.coordinateInside(c1));
        Coordinate c2 = new Coordinate(7, 8);
        assertTrue(battle.coordinateInside(c2));
        Coordinate c3 = new Coordinate(9, 13);
        assertTrue(battle.coordinateInside(c3));
        Coordinate c4 = new Coordinate(18, 19);
        assertTrue(battle.coordinateInside(c4));
        Coordinate c5 = new Coordinate(21, 21);
        assertFalse(battle.coordinateInside(c5));
        Coordinate c6 = new Coordinate(20, 21);
        assertFalse(battle.coordinateInside(c6));
        Coordinate c7 = new Coordinate(21, 4);
        assertFalse(battle.coordinateInside(c7));
    }

    /**
     * This method tests if Ships can stay inside the
     * Battlefield r don't respect Coordinates,
     * so they can't stay inside the Battlefield.
     */
    @Test
    public void testPositionShipInside() {
        Battlefield battle = new Battlefield(20, ships, color);
        addShips();
        Ship s1 = new Ship(new Coordinate(5, 5), 1, 2);
        Ship s2 = new Ship(new Coordinate(4, 4), 2, 3);
        Ship s3 = new Ship(new Coordinate(12, 12), 3, 3);
        Ship s4 = new Ship(new Coordinate(8, 8), 4, 1);
        assertTrue(battle.positionShipInside(s1));
        assertTrue(battle.positionShipInside(s2));
        assertTrue(battle.positionShipInside(s3));
        assertTrue(battle.positionShipInside(s4));
        Ship s5 = new Ship(new Coordinate(23, 23), 1, 2);
        assertFalse(battle.positionShipInside(s5));
        Ship s6 = new Ship(new Coordinate(18, 18), 1, 4);
        assertFalse(battle.positionShipInside(s6));
    }

    /**
     * This method test the correct functioning when
     * trying to add a Ship (passed between the
     * parameters) within the Battlefield, then carry out
     * checks if a Ship already exists in that position
     * or more.
     */
    @Test
    public void testApplyShipInside() {
        addShips();
        Battlefield battle = new Battlefield(20, ships, color);
        assertThrows(NullPointerException.class, () -> battle.applyShipInside(null));
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(s1));
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(s2));
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(s3));
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(s4));
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(s5));
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(s6));
        Ship f1 = new Ship(new Coordinate(21,21), 1, 4);
        Ship f2 = new Ship(new Coordinate(30,30), 3,3);
        Ship f3 = new Ship(new Coordinate(18,2), 1,4);
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(f1));
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(f2));
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(f3));
        Ship s = new Ship(new Coordinate(18,15), 2,3);
        battle.applyShipInside(s);
        assertTrue(battle.getShipInside().contains(s));
        Ship s1 = new Ship(new Coordinate(20,15), 3,3);
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(s1));
    }

    /**
     * This method tests the correct Coordinates applied
     * to the matrix if a Ship is applied within the Battlefield.
     */
    @Test
    public void testApplyMatrixCoordinate() {
        addShips();
        Battlefield battle = new Battlefield(20, ships, color);
        Coordinate [] c1 = s1.allShipPosition();
        assertEquals(c1[0], battle.getPositionBattlefield()[c1[0].getXPoint()][c1[0].getYPoint()]);
        assertEquals(c1[1], battle.getPositionBattlefield()[c1[1].getXPoint()][c1[1].getYPoint()]);
        assertEquals(c1[2], battle.getPositionBattlefield()[c1[2].getXPoint()][c1[2].getYPoint()]);
        Coordinate [] c2 = s2.allShipPosition();
        assertEquals(c2[0], battle.getPositionBattlefield()[c2[0].getXPoint()][c2[0].getYPoint()]);
        assertEquals(c2[1], battle.getPositionBattlefield()[c2[1].getXPoint()][c2[1].getYPoint()]);
        assertEquals(c2[2], battle.getPositionBattlefield()[c2[2].getXPoint()][c2[2].getYPoint()]);
        assertEquals(c2[3], battle.getPositionBattlefield()[c2[3].getXPoint()][c2[3].getYPoint()]);
        Coordinate [] c3 = s3.allShipPosition();
        assertEquals(c3[0], battle.getPositionBattlefield()[c3[0].getXPoint()][c3[0].getYPoint()]);
        assertEquals(c3[1], battle.getPositionBattlefield()[c3[1].getXPoint()][c3[1].getYPoint()]);
        assertEquals(c3[2], battle.getPositionBattlefield()[c3[2].getXPoint()][c3[2].getYPoint()]);
        Coordinate [] c4 = s4.allShipPosition();
        assertEquals(c4[0], battle.getPositionBattlefield()[c4[0].getXPoint()][c4[0].getYPoint()]);
        assertEquals(c4[1], battle.getPositionBattlefield()[c4[1].getXPoint()][c4[1].getYPoint()]);
        assertEquals(c4[2], battle.getPositionBattlefield()[c4[2].getXPoint()][c4[2].getYPoint()]);
        assertEquals(c4[3], battle.getPositionBattlefield()[c4[3].getXPoint()][c4[3].getYPoint()]);
        Coordinate [] c5 = s5.allShipPosition();
        assertEquals(c5[0], battle.getPositionBattlefield()[c5[0].getXPoint()][c5[0].getYPoint()]);
        assertEquals(c5[1], battle.getPositionBattlefield()[c5[1].getXPoint()][c5[1].getYPoint()]);
        Ship s6 = new Ship(new Coordinate(18,15), 2,3);
        Coordinate [] c6 = s6.allShipPosition();
        assertEquals(18, c6[0].getXPoint());
        assertEquals(15, c6[0].getYPoint());
        assertEquals(18, c6[1].getXPoint());
        assertEquals(16, c6[1].getYPoint());
        assertEquals(18, c6[2].getXPoint());
        assertEquals(17, c6[2].getYPoint());
        battle.applyShipInside(s6);
        assertEquals(c6[0], battle.getPositionBattlefield()[c6[0].getXPoint()][c6[0].getYPoint()]);
        assertEquals(c6[1], battle.getPositionBattlefield()[c6[1].getXPoint()][c6[1].getYPoint()]);
        assertEquals(c6[2], battle.getPositionBattlefield()[c6[2].getXPoint()][c6[2].getYPoint()]);
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(s1));
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(s2));
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(s3));
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(s4));
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(s5));
        assertThrows(IllegalArgumentException.class, () -> battle.applyShipInside(s6));
    }

    /**
     * This method tests the correct operation for the
     * removal of a Ship inside the Battlefield,
     * should the ship be sunk by the opponent.
     */
    @Test
    public void testRemoveShip(){
        addShips();
        Battlefield battle = new Battlefield(20, ships, color);
        Ship s6 = new Ship(new Coordinate(18,15), 2,3);
        Coordinate [] c1 = s6.allShipPosition();
        assertThrows(IllegalArgumentException.class, () -> battle.removeShip(s6));
        battle.removeShip(s1);
        assertNotEquals(ships, battle.getShipInside());
        assertNotEquals(c1[0], battle.getPositionBattlefield()[c1[0].getXPoint()][c1[0].getYPoint()]);
        assertNotEquals(c1[1], battle.getPositionBattlefield()[c1[1].getXPoint()][c1[1].getYPoint()]);
        assertNotEquals(c1[2], battle.getPositionBattlefield()[c1[2].getXPoint()][c1[2].getYPoint()]);
        assertNull(battle.getPositionBattlefield()[c1[0].getXPoint()][c1[0].getYPoint()]);
        assertNull(battle.getPositionBattlefield()[c1[1].getXPoint()][c1[1].getYPoint()]);
        assertNull(battle.getPositionBattlefield()[c1[2].getXPoint()][c1[2].getYPoint()]);

    }

    /**
     * This method tests the method that returns
     * all ships present within the Battlefield.
     */
    @Test
    public void testGetShipInside() {
        addShips();
        Battlefield battle = new Battlefield(20, ships, color);
        assertEquals(ships, battle.getShipInside());
        Ship s6 = new Ship(new Coordinate(18, 15), 2, 3);
        battle.applyShipInside(s6);
        ships.add(s6);
        assertEquals(ships, battle.getShipInside());
    }

    /**
     * This method tests the correct functioning of
     * the method that deals with verifying if a
     * given ship is present in a given coordinate.
     */
    @Test
    public void testIsPresentShipCoordinate(){
        addShips();
        Battlefield battle = new Battlefield(20, ships, color);
        assertTrue(battle.isPresentShipCoordinates(s1));
        assertTrue(battle.isPresentShipCoordinates(s2));
        assertTrue(battle.isPresentShipCoordinates(s3));
        assertTrue(battle.isPresentShipCoordinates(s4));
        assertTrue(battle.isPresentShipCoordinates(s5));
        Ship s6 = new Ship(new Coordinate(1,1), 1, 1);
        assertFalse(battle.isPresentShipCoordinates(s6));
    }

    /**
     *This method tests the correct functioning of
     * the method that deals with removing a position inside the matrix or
     * any Ship.
     */
    @Test
    public void testDeleteOnePosition(){
        addShips();
        Battlefield battle = new Battlefield(20, ships, color);
        Coordinate h1 = new Coordinate(5,5);
        battle.deleteOnePosition(h1);
        assertNull(battle.getPositionBattlefield()[h1.getXPoint()][h1.getYPoint()]);
        Coordinate h2 = new Coordinate(6,5);
        battle.deleteOnePosition(h2);
        Coordinate h3 = new Coordinate(7,5);
        battle.deleteOnePosition(h3);
        assertFalse(battle.getShipInside().contains(s1));
        Coordinate h4 = new Coordinate(10,17);
        Coordinate h5 = new Coordinate(10,18);
        battle.deleteOnePosition(h4);
        assertTrue(battle.getShipInside().contains(s5));
        battle.deleteOnePosition(h5);
        assertFalse(battle.getShipInside().contains(s5));

    }

}
