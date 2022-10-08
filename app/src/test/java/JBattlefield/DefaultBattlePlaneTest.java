package JBattlefield;

import JBattlefield.Model.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
public class DefaultBattlePlaneTest {

    RGBColor color = new RGBColor(0, 0, 0);

    Ship s1 = new Ship(new Coordinate(2, 3), 2, 3);
    Ship s2 = new Ship(new Coordinate(9, 4), 2, 3);
    Ship s3 = new Ship(new Coordinate(13, 15), 4, 3);
    Ship s4 = new Ship(new Coordinate(4, 8), 1, 3);
    Ship s5 = new Ship(new Coordinate(13, 10), 3, 3);
    Ship s6 = new Ship(new Coordinate(4, 13), 2, 2);
    Set<Ship> play1 = new HashSet<>();

    void addPlayerOneShip() {
        Collections.addAll(play1, s1, s2, s3, s4, s5, s6);
    }


    Ship sp1 = new Ship(new Coordinate(3, 4), 2, 3);
    Ship sp2 = new Ship(new Coordinate(3, 11), 2, 2);
    Ship sp3 = new Ship(new Coordinate(8, 9), 3, 3);
    Ship sp4 = new Ship(new Coordinate(10, 2), 2, 3);
    Ship sp5 = new Ship(new Coordinate(11, 14), 4, 3);
    Ship sp6 = new Ship(new Coordinate(12, 9), 1, 3);

    Set<Ship> play2 = new HashSet<>();

    void addPlayerTwoShip() {
        Collections.addAll(play2, sp1, sp2, sp3, sp4, sp5, sp6);
    }

    /**
     * This method tests for correct operation
     * on null parameters.
     */
    @Test
    public void testNullParameters(){
        assertThrows(NullPointerException.class, () -> new DefaultBattlePlane(null));
    }

    /**
     * This method tests the correct functioning of
     * the part of the codde concerning the attack
     * of a player and the addition of markers to
     * the data structure, so when a player fires a shot
     * in given position, this Coordinate must be saved in his
     * DefaultBattlePlane.
     */
    @Test
    public void testAddMarker(){
        addPlayerOneShip();
        addPlayerTwoShip();
        Player one = new Player("Alessio", play1, 20, color);
        Player two = new Player("Luca", play2, 20, color);
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
        assertTrue(one.getDefaultBattlePlane().listDeadShips().contains(sp1));
        assertFalse(two.getBattlefield().containsShip(sp1));
        assertFalse(two.containsShip(sp1));
    }

    /**
     * This method tests the correct Coordinates that
     * a Player has hit and then saved in this Structure.
     */
    @Test
    public void testGetHitPosition(){
        addPlayerOneShip();
        addPlayerTwoShip();
        Player one = new Player("Alessio", play1, 20, color);
        Player two = new Player("Luca", play2, 20, color);
        Map<Coordinate, Boolean> map = one.getDefaultBattlePlane().hitPosition();
        assertEquals(map, one.getDefaultBattlePlane().hitPosition());
        Map<Coordinate, Boolean> map2 = two.getDefaultBattlePlane().hitPosition();
        assertEquals(map2, map2);
    }

    /**
     * This method tests the correct functioning for
     * the return of the Ships that managed to sink.
     */
    @Test
    public void testGetListDeadShips(){
        addPlayerOneShip();
        addPlayerTwoShip();
        Player one = new Player("Alessio", play1, 20, color);
        Player two = new Player("Luca", play2, 20, color);
        List<Ship> deadOne = one.getDefaultBattlePlane().listDeadShips();
        assertEquals(deadOne, one.getDefaultBattlePlane().listDeadShips());
        List<Ship> deadTwo = two.getDefaultBattlePlane().listDeadShips();
        assertEquals(deadTwo, two.getDefaultBattlePlane().listDeadShips());

    }
}
