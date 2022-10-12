package JBattlefield;


import JBattlefield.Model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class ActionTest {

    private final RGBColor color = new RGBColor(0, 0, 0);

    private final Ship s1 = new Ship(new Coordinate(2, 3), 2, 3);
    private final Ship s2 = new Ship(new Coordinate(9, 4), 2, 3);
    private final Ship s3 = new Ship(new Coordinate(13, 15), 4, 3);
    private final Ship s4 = new Ship(new Coordinate(4, 8), 1, 3);
    private final Ship s5 = new Ship(new Coordinate(13, 10), 3, 3);
    private final Ship s6 = new Ship(new Coordinate(4, 13), 2, 2);
    private final Set<Ship> play1 = new HashSet<>();

    private void addPlayerOneShip() {
        Collections.addAll(play1, s1, s2, s3, s4, s5, s6);
    }

    private final Ship sp1 = new Ship(new Coordinate(3, 4), 2, 3);
    private final Ship sp2 = new Ship(new Coordinate(3, 11), 2, 2);
    private final Ship sp3 = new Ship(new Coordinate(8, 9), 3, 3);
    private final Ship sp4 = new Ship(new Coordinate(10, 2), 2, 3);
    private final Ship sp5 = new Ship(new Coordinate(11, 14), 4, 3);
    private final Ship sp6 = new Ship(new Coordinate(12, 9), 1, 3);

    private final Set<Ship> play2 = new HashSet<>();

    private void addPlayerTwoShip() {
        Collections.addAll(play2, sp1, sp2, sp3, sp4, sp5, sp6);
    }


    /**
     * This method allows to test the correct functioning
     * with control from every single part concerning the part
     * of the program that gets the attack of a player in a determinate
     * Coordinate on an opponent Player.
     */
    @Test
    public void testAction() {
        addPlayerOneShip();
        addPlayerTwoShip();
        Player one = new Player("Alessio", play1, 20, color);
        Player two = new Player("Luca", play2, 20, color);
        //SHIP PLAYER 2:
        //SP1
        assertTrue(two.getBattlefield().containsShip(sp1));
        Coordinate c1 = new Coordinate(3, 4);
        one.hitPosition(two, c1);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c1));
        Coordinate c2 = new Coordinate(3, 5);
        one.hitPosition(two, c2);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c2));
        Coordinate c3 = new Coordinate(3, 6);
        one.hitPosition(two, c3);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c3));
        assertFalse(two.getBattlefield().containsShip(sp1));
        assertFalse(two.containsShip(sp1));
        //SP3
        assertTrue(two.getBattlefield().containsShip(sp3));
        Coordinate c4 = new Coordinate(6, 9);
        one.hitPosition(two, c4);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c4));
        Coordinate c5 = new Coordinate(7, 9);
        one.hitPosition(two, c5);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c5));
        Coordinate c6 = new Coordinate(8, 9);
        one.hitPosition(two, c6);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c6));
        assertFalse(two.getBattlefield().containsShip(sp3));
        assertFalse(two.containsShip(sp3));
        //SP4
        assertTrue(two.getBattlefield().containsShip(sp4));
        Coordinate c7 = new Coordinate(10, 2);
        one.hitPosition(two, c7);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c7));
        Coordinate c8 = new Coordinate(10, 3);
        one.hitPosition(two, c8);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c8));
        Coordinate c9 = new Coordinate(10, 4);
        one.hitPosition(two, c9);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c9));
        assertFalse(two.getBattlefield().containsShip(sp4));
        assertFalse(two.containsShip(sp4));
        //SHIP PLAYER 1:
        //S1
        assertTrue(one.getBattlefield().containsShip(s1));
        Coordinate c10 = new Coordinate(2, 3);
        two.hitPosition(one, c10);
        assertTrue(two.getDefaultBattlePlane().hitPosition().containsKey(c10));
        Coordinate c11 = new Coordinate(2, 4);
        two.hitPosition(one, c11);
        assertTrue(two.getDefaultBattlePlane().hitPosition().containsKey(c11));
        Coordinate c12 = new Coordinate(2, 5);
        two.hitPosition(one, c12);
        assertTrue(two.getDefaultBattlePlane().hitPosition().containsKey(c12));
        assertFalse(one.getBattlefield().containsShip(s1));
        assertFalse(one.containsShip(s1));
        //S2
        assertTrue(one.getBattlefield().containsShip(s2));
        Coordinate c13 = new Coordinate(9, 4);
        two.hitPosition(one, c13);
        assertTrue(two.getDefaultBattlePlane().hitPosition().containsKey(c13));
        Coordinate c14 = new Coordinate(9, 5);
        two.hitPosition(one, c14);
        assertTrue(two.getDefaultBattlePlane().hitPosition().containsKey(c14));
        Coordinate c15 = new Coordinate(9, 6);
        two.hitPosition(one, c15);
        assertTrue(two.getDefaultBattlePlane().hitPosition().containsKey(c15));
        assertFalse(one.getBattlefield().containsShip(s2));
        assertFalse(one.containsShip(s2));
        //S6
        assertTrue(one.getBattlefield().containsShip(s6));
        Coordinate c16 = new Coordinate(4, 13);
        two.hitPosition(one, c16);
        assertTrue(two.getDefaultBattlePlane().hitPosition().containsKey(c16));
        Coordinate c17 = new Coordinate(4, 14);
        two.hitPosition(one, c17);
        assertTrue(two.getDefaultBattlePlane().hitPosition().containsKey(c17));
        assertFalse(one.getBattlefield().containsShip(s6));
        assertFalse(one.containsShip(s6));
    }
    
     @Test
    public void testWin(){
        addPlayerOneShip();
        addPlayerTwoShip();
        Player one = new Player("Alessio", play1, 20, color);
        Player two = new Player("Luca", play2, 20, color);
        //hit and sunk Ship SP1
        assertTrue(two.getBattlefield().containsShip(sp1));
        Coordinate c1 = new Coordinate(3, 4);
        one.hitPosition(two, c1);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c1));
        Coordinate c2 = new Coordinate(3, 5);
        one.hitPosition(two, c2);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c2));
        Coordinate c3 = new Coordinate(3, 6);
        one.hitPosition(two, c3);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c3));
        assertFalse(two.getBattlefield().containsShip(sp1));
        assertFalse(two.containsShip(sp1));
        //hit and sunk Ship SP2
        assertTrue(two.getBattlefield().containsShip(sp2));
        Coordinate c4 = new Coordinate(3,11);
        one.hitPosition(two, c4);
        Coordinate c5 = new Coordinate(3,12);
        one.hitPosition(two, c5);
        assertFalse(two.getBattlefield().containsShip(sp2));
        assertFalse(two.containsShip(sp2));
        //hit and sunk Ship SP3
        assertTrue(two.getBattlefield().containsShip(sp3));
        Coordinate c6 = new Coordinate(8,9);
        one.hitPosition(two, c6);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c6));
        Coordinate c7 = new Coordinate(7,9);
        one.hitPosition(two, c7);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c7));
        Coordinate c8 = new Coordinate(6,9);
        one.hitPosition(two, c8);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c8));
        assertFalse(two.getBattlefield().containsShip(sp3));
        assertFalse(two.containsShip(sp3));
        //hit and sunk Ship SP4
        assertTrue(two.getBattlefield().containsShip(sp4));
        Coordinate c9 = new Coordinate(10,2);
        one.hitPosition(two, c9);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c9));
        Coordinate c10 = new Coordinate(10,3);
        one.hitPosition(two, c10);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c10));
        Coordinate c11 = new Coordinate(10,4);
        one.hitPosition(two, c11);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c11));
        assertFalse(two.getBattlefield().containsShip(sp4));
        assertFalse(two.containsShip(sp4));
        //hit and sunk Ship SP5
        assertTrue(two.getBattlefield().containsShip(sp5));
        Coordinate c12 = new Coordinate(11,14);
        one.hitPosition(two, c12);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c12));
        Coordinate c13 = new Coordinate(11,13);
        one.hitPosition(two, c13);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c13));
        Coordinate c14 = new Coordinate(11,12);
        one.hitPosition(two, c14);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c14));
        assertFalse(two.getBattlefield().containsShip(sp5));
        assertFalse(two.containsShip(sp5));
        //hit and sunk Ship SP6
        assertTrue(two.getBattlefield().containsShip(sp6));
        Coordinate c15 = new Coordinate(12,9);
        one.hitPosition(two, c15);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c15));
        Coordinate c16 = new Coordinate(13,9);
        one.hitPosition(two, c16);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c16));
        Coordinate c17 = new Coordinate(14,9);
        one.hitPosition(two, c17);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(c17));
        assertFalse(two.getBattlefield().containsShip(sp6));
        assertFalse(two.containsShip(sp6));
        //Test failure hit
        Coordinate c18 = new Coordinate(1,1);
        assertThrows(IllegalArgumentException.class, () -> one.hitPosition(two, c18));
    }
}
