package JBattlefield.Model;

import java.util.*;

/**
 * This class provides a default implementation of the
 * Plane interface. It aims to rapresent the concept of
 * the second BattlePlane made available for a particular player,
 * and serves to mark the positions we have attacked for the enemy
 * and any Ships that we managed to destroy.
 */
public class DefaultBattlePlane implements Plane {

    /**
     * The player for the game.
     */
    private final Player player;

    /**
     * A map that maps key to value, where the
     * key is a Coordinate, and the value is a Boolean.
     * This collection structure is necessary
     * as a Player when firint into hit opponent's
     * BattleArea must take into account the
     * Position he fired and whether they took
     * a Ship or not.
     */
    private final Map<Coordinate, Boolean> hitPosition;

    /**
     * The list of Ships that this Player
     * managed to sink.
     */
    private final List<Ship> listDeadShip;

    /**
     * Constructor creating an Area to memorize the
     * Positions (Coordinates) of the fired battle area.
     *
     * @param player the Player for this DefaultBattlePlane.
     */
    public DefaultBattlePlane(Player player) {
        Objects.requireNonNull(player);
        this.player = player;
        this.hitPosition = new HashMap<>();
        this.listDeadShip = new ArrayList<>();
    }

    @Override
    public void addMarker(Coordinate tmp, boolean result) {
        if (this.hitPosition.containsKey(tmp))
            throw new IllegalArgumentException("Position already hit.");
        this.hitPosition.put(tmp, result);
    }

    @Override
    public Map<Coordinate, Boolean> hitPosition() {
        return this.hitPosition;
    }

    @Override
    public List<Ship> listDeadShips() {
        return this.listDeadShip;
    }
}
