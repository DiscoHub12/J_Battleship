package JBattlefield;

import JBattlefield.Model.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This Test class is a class that allows you
 * to carry out Testing concerning the Player
 * of the Naval Battle.
 * In fact, it tests the correctness of each method
 * that we find in the Player class.
 */
public class PlayerTest {

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

    /**
     * This method tests the correct functioning of
     * exception raising in case a player accepts null
     * parameters.
     */
    @Test
    public void testIllegalParameters(){
        addPlayerOneShip();
        assertThrows(NullPointerException.class, () -> new Player(null, play1, 20, color));
        assertThrows(NullPointerException.class, () -> new Player("Alessio", null, 20, color));
        assertThrows(NullPointerException.class, () -> new Player("Alessio", play1, 20, null));
        assertThrows(IllegalArgumentException.class, () -> new Player("Alessio", play1, 19, color));
    }

    /**
     * This method tests the correct functioning of
     * return of the player's Ships.
     */
    @Test
    public void testGetShipsPlayer(){
        addPlayerOneShip();
        Player one = new Player("Alessio", play1, 20, color);
        Set<Ship> ships = one.shipPlayer();
        assertEquals(ships, one.shipPlayer());
        one.removeShip(s1);
        ships.remove(s1);
        assertEquals(ships, one.shipPlayer());
    }

    /**
     * This method tests the correct functioning of
     * the player's Battlefield return.
     */
    @Test
    public void testGetBattlefield(){
        addPlayerOneShip();
        Player one = new Player("Alessio", play1, 20, color);
        Battlefield battle = new Battlefield(20, one.shipPlayer(), color);
        assertEquals(battle, one.getBattlefield());
        DefaultBattlePlane def = new DefaultBattlePlane(one);
        assertEquals(def, one.getDefaultBattlePlane());
    }

    /**
     * This method tests the correct functioning
     * concerning the removal of a specific Ship
     * owned by specific player.
     */
    @Test
    public void testRemoveShip(){
        addPlayerOneShip();
        Player one = new Player("Alessio", play1, 20, color);
        one.getBattlefield().removeShip(s1);
        assertFalse(one.getBattlefield().containsShip(s1));
        one.removeShip(s1);
        assertFalse(one.shipPlayer().contains(s1));
    }

    /**
     * This method tests the correct functioning
     * concerning the possibility of hitting
     * a certain Coordinate of an opposing player.
     */
    @Test
    public void testHitPosition(){
        addPlayerOneShip();
        Player one = new Player("Alessio", play1, 20, color);
        Player two = new Player("Luca", play1, 20, color);
        Coordinate tmp = new Coordinate(2,3);
        one.hitPosition(two, tmp);
        assertTrue(one.getDefaultBattlePlane().hitPosition().containsKey(tmp));
        two.hitPosition(one, tmp);
        assertTrue(two.getDefaultBattlePlane().hitPosition().containsKey(tmp));
    }


}
