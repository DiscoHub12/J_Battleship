package JBattlefield.Model;

import java.util.List;
import java.util.Map;

/**
 * This interface provides a number of methods that are
 * useful and rapresent a player's second BattlePlane. In fact, it
 * is implemented by the DefaultBattlePlane.
 */
public interface Plane {

    /**
     * If a Player shoots a precise Position (Coordinate)
     * of an opponent's Area, this method allows you
     * to memorize the Coordinate hit and a true value
     * if he hit the Ship, false otherwise.
     *
     * @param tmp    the Coordinate that the Player shoot.
     * @param result the boolean value.
     */
    void addMarker(Coordinate tmp, boolean result);

    /**
     * This method return the collections(Map) which
     * stores the fired position (Coordinate) of a
     * particular Player and the positive (if it hit the
     * Ship) or negative value.
     *
     * @return true if he hit a Ship, false otherwise.
     */
    Map<Coordinate, Boolean> hitPosition();

    /**
     * This method return the List of Ship
     * that the Player managed to sink.
     *
     * @return the list of Ship that the Player managed to sink.
     */
    List<Ship> listDeadShips();

}
