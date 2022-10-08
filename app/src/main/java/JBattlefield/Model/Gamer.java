package JBattlefield.Model;

import java.util.Set;

/**
 * This interface provides a series of useful and
 * necesary methods to rapresent the concept of Player
 * within the Naval Battle.
 * This interface is implemented by the Player class.
 */
public interface Gamer {

    /**
     * This method allows you to return the
     * Player name.
     *
     * @return the player name.
     */
    String getName();

    /**
     * This method allows you yo return all the
     * Ships present and in possession of the Player
     * himself.
     *
     * @return all the Ships for the Player.
     */
    Set<Ship> shipPlayer();

    /**
     * This method allows you to return the
     * main Battlefield of the player himself.
     *
     * @return the Battlefield of the Player.
     */
    Battlefield getBattlefield();

    /**
     * This method allows you to return the
     * second field of the same Player (DefaultBattlePlane).
     *
     * @return the DefaultBattlePlane of this Player.
     */
    DefaultBattlePlane getDefaultBattlePlane();

    /**
     * This method allows you to remove a particular
     * player's Ship if the opponent manages to destroy it.
     *
     * @param ship the Ship to remove.
     * @throws IllegalArgumentException if the Ship isn't present into the list
     *                                  of player's Ships.
     * @throws NullPointerException     if the ship is null.
     */
    void removeShip(Ship ship);

    /**
     * This method allows the Player to shoot a certain
     * position of the opponent's Battlefield.
     *
     * @param player     the opponent's Player.
     * @param coordinate the position to shoot.
     * @throws NullPointerException if the player or coordinate are null.
     */
    void hitPosition(Player player, Coordinate coordinate);

}
