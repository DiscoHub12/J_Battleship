package JBattlefield.Model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * This class provides a default implementation of the
 * I_Battlefield interface.
 * Its rapresents the concepr of the Battlefield owned by each
 * individual Player, in which a Player will place his Ships,
 * and the game interrvenes in this Object. In nfact, we find methods
 * such as removing a boat (if the opponent manages to destroy it),
 * methods to apply and then position the Ships within this field
 * and much more. Obviously, a Player must
 * own one and only one Battlefield.
 */
public class Battlefield implements I_Battlefield {

    /**
     * The base of Battlefield.
     */
    private final int base;

    /**
     * The height of this Battlefield.
     */
    private final int heigth;

    /**
     * The Battlefield area expressed as a
     * Coordinate matrix.
     */
    private final Coordinate[][] positionBattlefield;


    /**
     * The list of Ships (Set) present
     * within this Battlefield.
     */
    private final Set<Ship> shipInside;

    /**
     * The color (RGBColor) for this Battlefield.
     */
    private RGBColor colorArea;

    /**
     * Constructor that allows you to create a specific
     * player's Battlefield. Inside it , will have the list
     * of Ship that the Player owns and a color (RGBColor).
     *
     * @param base  the base length for this Battlefield.
     * @param ships the Ships (Player) for this Battlefield.
     * @param color the color (RGBColor) for this Battlefield.
     */
    public Battlefield(int base, Set<Ship> ships, RGBColor color) {
        Objects.requireNonNull(ships);
        Objects.requireNonNull(color);
        this.base = base;
        this.heigth = base;
        this.colorArea = color;
        this.positionBattlefield = new Coordinate[this.base][this.base];
        this.shipInside = new HashSet<>();
        if (ships.size() == 6) {
            applyAllShip(ships);
        } else throw new IllegalArgumentException("Illegal number of Ship.");

    }

    @Override
    public int getBaseHeight() {
        return this.base;
    }

    @Override
    public RGBColor getColorArea() {
        return this.colorArea;
    }

    @Override
    public void setColorArea(RGBColor color) {
        Objects.requireNonNull(color);
        this.colorArea = color;
    }

    @Override
    public boolean coordinateInside(Coordinate tmp) {
        Objects.requireNonNull(tmp);
        return tmp.getXPoint() <= this.base && tmp.getYPoint() <= this.heigth;
    }

    @Override
    public boolean positionShipInside(Ship ship) {
        Objects.requireNonNull(ship);
        return coordinateInside(ship.getStart()) && coordinateInside(ship.getEnd());
    }

    @Override
    public void applyShipInside(Ship ship) {
        Objects.requireNonNull(ship);
        if (containsShip(ship))
            throw new IllegalArgumentException("Ship already present.");
        if (!positionShipInside(ship))
            throw new IllegalArgumentException("This Ship doesn't respect the limits of the Battlefield.");
        if (isPresentShipCoordinates(ship))
            throw new IllegalArgumentException("There is Ship in this position.");
        this.shipInside.add(ship);
        applyAtMatrixCoordinate(ship);
    }

    @Override
    public void applyAtMatrixCoordinate(Ship ship) {
        Objects.requireNonNull(ship);
        Coordinate[] occupied = ship.allShipPosition();
        for (Coordinate c : occupied) {
            this.positionBattlefield[c.getXPoint()][c.getYPoint()] = c;
        }
    }

    @Override
    public void applyAllShip(Set<Ship> ships) {
        Objects.requireNonNull(ships);
        for (Ship s : ships) {
            applyShipInside(s);
        }
    }

    @Override
    public void removeShip(Ship ship) {
        Objects.requireNonNull(ship);
        if (!this.shipInside.contains(ship))
            throw new IllegalArgumentException("Ship not exist in this Battlefield.");
        this.shipInside.remove(ship);
        applyMatrixCoordByDeleting(ship);
    }

    @Override
    public Set<Ship> getShipInside() {
        return this.shipInside;
    }

    @Override
    public Coordinate[][] getPositionBattlefield() {
        return this.positionBattlefield;
    }

    @Override
    public boolean containsShip(Ship ship) {
        Objects.requireNonNull(ship);
        for (Ship s : this.shipInside) {
            if (s.equals(ship))
                return true;
        }
        return false;
    }

    @Override
    public boolean isPresentShipCoordinates(Ship s) {
        for (Ship ships : this.shipInside) {
            for (Coordinate cord : ships.allShipPosition()) {
                for (Coordinate cord1 : s.allShipPosition()) {
                    if (cord.equals(cord1))
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * This method, if the Ship passed between parameters
     * has been sunk, applies and sets the occupied
     * Coordinates of the Ship (inside the Matrix) as null.
     *
     * @param ship the Ship to take into consideration.
     * @throws NullPointerException if the ship is null.
     */
    private void applyMatrixCoordByDeleting(Ship ship) {
        Coordinate[] tmp = ship.allShipPosition();
        for (Coordinate t : tmp) {
            this.positionBattlefield[t.getXPoint()][t.getYPoint()] = null;
        }
    }

    /**
     * This method allows you to check if all
     * positions (Coordinates) within the matrix of the
     * Battlefield plane are null, this indicating that
     * the Ship has been sunk.
     *
     * @param s the ship to apply the veritication.
     * @return the lenght of the Ship if it was actually sink, another value
     * otherwise.
     */
    private boolean checkNullShipPosition(Ship s) {
        Coordinate[] tmp = s.allShipPosition();
        int count = 0;
        for (Coordinate c : tmp) {
            if (this.positionBattlefield[c.getXPoint()][c.getYPoint()] == null)
                count++;
        }
        return count == tmp.length;
    }

    /**
     * This method allows you to return a specific
     * Ship if it is present in that Coordinate.
     *
     * @param tmp the Coordinates to check if a Ship is present.
     * @return the ship if is present, null otherwise.
     */
    public Ship getShipInThisPosition(Coordinate tmp) {
        Objects.requireNonNull(tmp);
        for (Ship s : this.shipInside) {
            for (Coordinate c : s.allShipPosition()) {
                if (c.equals(tmp))
                    return s;
            }
        }
        return null;
    }

    /**
     * This method allows to remove a given position
     * (Coordinate) within the matrix, that is, if there is
     * a Ship in that position, it adds a null value, and if
     * all the values of the Ship (checking in the matrix)
     * are null, then we can remove that Ship.
     *
     * @param tmp the coordinate to remove.
     * @throws NullPointerException if the Coordinate tmp is null.
     */
    public void deleteOnePosition(Coordinate tmp) {
        Objects.requireNonNull(tmp);
        Ship s = getShipInThisPosition(tmp);
        if (s != null) {
            this.positionBattlefield[tmp.getXPoint()][tmp.getYPoint()] = null;
            if (checkNullShipPosition(s)) {
                this.shipInside.remove(s);
            }
        }
    }
}

