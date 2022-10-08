package JBattlefield.Model;


/**
 * This interface provides methods necessary to rapresent
 * the concept of Coordinate inside the plane, , in fact it will
 * be implemented by the Coordinate class.
 */
public interface Position {

    /**
     * Get method to request the x point
     * of the Coordinate.
     *
     * @return the x point of the Coordinate
     */
    int getXPoint();

    /**
     * Set method to set the x point of the
     * Coordinate.
     *
     * @param x the x point of the Coordinate.
     */
    void setXPoint(int x);

    /**
     * Get method to request the y point
     * of the Coordinate.
     *
     * @return the y point of the Coordinate.
     */
    int getYPoint();

    /**
     * Set method to set the y point of the
     * Coordinate.
     *
     * @param y the y point of the Coordinate.
     */
    void setYPoint(int y);

    /**
     * The equals method of a Coordinate class simply
     * checks if two coordinates are equal, so if they have the
     * same x and y value.
     *
     * @param obj the Object to compare.
     * @return true if the two Coordinate are equals , false otherwise.
     */
    boolean equals(Object obj);

}
