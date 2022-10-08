package JBattlefield.Model;


import java.util.Set;

/**
 * This interface is essential to rapresent a program with
 * the purspose of providing an implementation for the Naval Battle.
 * As it provides a number of methods that will be implemented à
 * by the Battlefield class, with the aim of rapresenting the battelfield
 * of Naval Battle.
 */
public interface I_Battlefield {

    /**
     * @return the base of the Battlefield.
     * (base and heigth are equals, because the Battlefield is Square)
     */
    int getBaseHeight();

    /**
     * @return the color (RGBColor) for the Battlefield.
     */
    RGBColor getColorArea();

    /**
     * @param color the color (RGBColor) to set for the Battlefield.
     * @throws NullPointerException if the <color> is null.
     */
    void setColorArea(RGBColor color);

    /**
     * @param tmp the Coordinate to checks.
     * @return true if the Coordinate tmp is inside the Battlefield,
     * false otherwise.
     * @throws NullPointerException if the <tmp> is null.
     */
    boolean coordinateInside(Coordinate tmp);

    /**
     * This method checks if the Ship's Coordinates are
     * inside the Plane or not.
     *
     * @param ship the ship to checks the Coordinates.
     * @return true if the Coordinates is inside, false otherwise.
     * @throws NullPointerException if the ship is null.
     */
    boolean positionShipInside(Ship ship);

    /**
     * This method allows you to apply a certain Ship within
     * the BattleField, after having carried out cerain checks.
     *
     * @param ship
     * @throws NullPointerException     if the <ship> is null.
     * @throws IllegalArgumentException if the ship is already present-the position
     *                                  of the ship is not inside the plane-there is already ships inside this position.
     */
    void applyShipInside(Ship ship);

    /**
     * This method allows you to apply and mark the Coordinates
     * of a specific Ship, within the Matrix that rapresents the Battlefield.
     *
     * @param ship the ship to apply at the matrix Battlefield.
     * @throws NullPointerException if the <ship> is null.
     */
    void applyAtMatrixCoordinate(Ship ship);

    /**
     * This method allows you to apply , then call the
     * <applyShipInside> method for each Player's Ships.
     *
     * @param ships the Ships to apply in the Battlefield.
     * @throws NullPointerException if the ships are null.
     */
    void applyAllShip(Set<Ship> ships);

    /**
     * This method allows you to remove a specific Ship from
     * within the Battlefield, should the opponent manage to
     * destroy it.
     *
     * @param ship the ship to remove.
     * @throws NullPointerException     if the <ship> is null.
     * @throws IllegalArgumentException if the <ship> is not present into the
     *                                  Battlefield.
     */
    void removeShip(Ship ship);

    /**
     * This method returns all the Ships present inside
     * the Battlefield.
     *
     * @return the list (Set) Ships inside the Battlefield.
     */
    Set<Ship> getShipInside();

    /**
     * This method returns the matrix it rapresent the Battlefield.
     *
     * @return the matrix coordinate for the Battlefield.
     */
    Coordinate[][] getPositionBattlefield();

    /**
     * This method checks if the Ship passed in the
     * parameters is present within the Battlefield.
     *
     * @param ship the ship to check.
     * @return true if the ship is present inside the Battlefield, false
     * otherwise.
     * @throws NullPointerException if the ship is null.
     */
    boolean containsShip(Ship ship);

    /**
     * This method checks if the position of the
     * given Ship as parameters are already
     * occupied by another Ship or no.
     *
     * @param ship the ship to check.
     * @return true if there is already ship in this
     * position, falkse otherwise.
     * @throws NullPointerException if the ship is null.
     */
    boolean isPresentShipCoordinates(Ship ship);


}
