package JBattlefield.Model;

/**
 * This interface provides the necessary methods
 * to rapresent the concept of the Ship within the
 * Naval Battle. In fact, the Ship class implements this
 * interface and therefore also all the useful and necessary
 * methods made avaible.
 */
public interface I_Ship {

    /**
     * Get method to request the length of
     * a specific Ship.
     *
     * @return the length of the Ship.
     */
    int getLength();


    /**
     * Get method to request the direction of a
     * specific Ship.
     *
     * @return the direction of the Ship.
     */
    int getDirection();

    /**
     * Set method to set the direction of a
     * specific Ship.
     *
     * @param direction the direction of the Ship.
     * @throws IllegalArgumentException if the direction is
     *                                  different from : 1,2,3,4.
     */
    void setDirection(int direction);

    /**
     * Get method to request the start Coordinate
     * of a specific Ship.
     *
     * @return the start Coordinate of the Ship.
     */
    Coordinate getStart();

    /**
     * Set method to set the start Coordinate
     * of a specific ship.This method is useful
     * as a Ship is not always correctly placed
     * inside a Battle Area.
     *
     * @param start the start Coordinate of the Ship.
     * @throws NullPointerException if the passed parameter
     *                              (Coordinate) is null.
     */
    void setStartCoordinate(Coordinate start);

    /**
     * Get method to request the end Coordinate
     * of a specific Ship.
     *
     * @return the end Coordinate of the Ship.
     */
    Coordinate getEnd();

    /**
     * This method returns the list (Array) of all
     * positions (Coordinates) that the Ship occupies.
     *
     * @return the list (Array) of all position (Coordinate) that
     * the Ship occupies.
     */
    Coordinate[] allShipPosition();

    /**
     * The Equals method of the Ship class simply
     * checks if two Ships are equals, so if they have the
     * same length, start position, end position , and the list
     * of all position (Coordinate) that the Ship occupies.
     *
     * @param obj the Object to compare.
     * @return true if the two Ships are equals, false otherwise.
     */
    boolean equals(Object obj);

}
