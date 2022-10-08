package JBattlefield.Model;

import java.util.Objects;
import java.util.Set;

public class Player implements Gamer {

    private final String name;

    private final Set<Ship> ships;

    private int count;

    private final Battlefield battlefield;

    private final DefaultBattlePlane defaultBattle;

    private final Action action;

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
        this.count = 0;
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
    public void addShip(Ship ship) {
        Objects.requireNonNull(ship);
        if (ships.contains(ship))
            throw new IllegalArgumentException("Ship already exist.");
        if (count >= 6)
            throw new IllegalArgumentException("You cannot add another ship inside.");
        this.ships.add(ship);
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

    public boolean containsShip(Ship ship) {
        Objects.requireNonNull(ship);
        for (Ship s : this.ships) {
            if (s.equals(ship))
                return true;
        }
        return false;
    }
}
