package JBattlefield.Model;

import java.util.Objects;
import java.util.Set;

public class Player implements Gamer {

     /**
     * This attribute indicates a unique
     * Player name.
     */
    private final String name;

    /**
     * This Collections (Set) indicates
     * the Ships that this particular Player
     * owns.
     */
    private final Set<Ship> ships;

    /**
     * This attribute indicates a
     * counter that will be decremented each time
     * this Player's Ship is sunk.
     */
    private int count;

    /**
     * This attribute indicates a unique Battlefield
     * for this Player.
     */
    private final Battlefield battlefield;

    /**
     * This attribute indicates a unique
     * DefaultBattlePlane for this Player.
     */
    private final DefaultBattlePlane defaultBattle;

    /**
     * This attribute indicates the actions a
     * player can perform, i.e hitting a
     * certain position on a battlefield of his
     * opponent.
     */
    private final Action action;

    /**
     * Constructor that allows you to create a Player,
     * who will have certain ships, a base indicating the
     * base of the two tables owned by the Player, and color
     * (RGB) for the base.
     * @param name the name of this Player.
     * @param ships the Ships that this Player have.
     * @param base the length for the Battlefield and DefaultBattlePlane.
     * @param color the color for the Battlefield and DefaultBattlePlane.
     */
    public Player(String name, Set<Ship> ships, int base, RGBColor color) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(ships);
        Objects.requireNonNull(color);
        if(base < 20)
            throw new IllegalArgumentException("Illegal base for the Battlefield.");
        this.name = name;
        this.ships = ships;
        this.battlefield = new Battlefield(base, ships, color);
        this.defaultBattle = new DefaultBattlePlane(this);
        this.count = this.ships.size();
        this.action = new Action(this);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Set<Ship> shipPlayer() {
        return ships;
    }

    @Override
    public Battlefield getBattlefield() {
        return this.battlefield;
    }

    @Override
    public DefaultBattlePlane getDefaultBattlePlane() {
        return this.defaultBattle;
    }

    @Override
    public void removeShip(Ship ship) {
        Objects.requireNonNull(ship);
        if (!containsShip(ship))
            throw new IllegalArgumentException("The Ship dosn't exist.");
        this.ships.remove(ship);
        this.count--;
    }

    @Override
    public void hitPosition(Player player, Coordinate coordinate) {
        if(this == player)
            throw new IllegalArgumentException("You have to hit the opponent, not yourself.");
        this.action.hitPosition(player, coordinate);
    }

    /**
     * This method checks whether a given Ship
     * passed between parameters is present or not.
     * @param ship the Ship to checks.
     * @return true if present, false otherwise.
     */
    public boolean containsShip(Ship ship) {
        Objects.requireNonNull(ship);
        for (Ship s : this.ships) {
            if (s.equals(ship))
                return true;
        }
        return false;
    }
}
