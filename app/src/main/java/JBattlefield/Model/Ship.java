package JBattlefield.Model;


import java.util.Objects;

/**
 * This class provides a default implementation
 * of the I_Ship interface. It aims to rapresent the
 * concepr of a Ship within the Naval Battle. In fact , a
 * Ship has an initial Coordinate, the final Coordinate,
 * the list of Coordinates that the Ship occupies, the direction
 * (as it must be positioned within a Battlefield) and the length.
 */
public class Ship implements I_Ship {

    /**
     * The initial Coordinate of this Ship
     * (which indicates the head, i.e the
     * first position of the Ship within a
     * Battle Area or plane)
     */
    private Coordinate start;

    /**
     * The final Coordinate of the Ship
     * (which indicates the final position
     * occupied by the Ship in a Battle area
     * or plane)
     */
    private Coordinate end;

    /**
     * The list (Array) of Coordinates
     * occupied by the Ship, depending on its
     * length.
     */
    private final Coordinate[] coordinatesOccupies;

    /**
     * The direction of this Ship. It can be a
     * value in the range from 0 to 4, which indicate
     * the direction angles correspondingly:
     * 0,90,180 or 270 degrees.
     */
    private int direction;

    /**
     * The length of this Ship.
     */
    private final int length;

    /**
     * The constructor that allows to create a Ship.
     *
     * @param start     the start position of this Ship.
     * @param direction the direction of this Ship.
     * @param length    the length of this Ship.
     */
    public Ship(Coordinate start, int direction, int length) {
        if (length <= 0 || length > 4)
            throw new IllegalArgumentException("Illegal length for the Ship.");
        this.setStartCoordinate(start);
        this.setDirection(direction);
        this.length = length;
        this.coordinatesOccupies = new Coordinate[length];
        this.applyShipCoordinate();
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getDirection() {
        return this.direction;
    }

    @Override
    public void setDirection(int direction) {
        if (direction == 1 || direction == 2 || direction == 3 || direction == 4) {
            this.direction = direction;
            applyShipCoordinate();
        } else throw new IllegalArgumentException("Illegal direction for the Ship.");
    }

    @Override
    public Coordinate getStart() {
        return this.start;
    }

    @Override
    public void setStartCoordinate(Coordinate start) {
        Objects.requireNonNull(start);
        this.start = start;
        this.applyShipCoordinate();
    }

    @Override
    public Coordinate getEnd() {
        Objects.requireNonNull(this.end);
        return this.end;
    }

    @Override
    public Coordinate[] allShipPosition() {
        return this.coordinatesOccupies;
    }

    /**
     * This method allows you to apply all
     * the Coordinates occupied by the Ship based on its
     * initial Coordinate, its length and direction.
     * For example, if the initial Coordinate of a Ship is
     * (5,5) , the direction is 0 (therefore it indicates
     * 0 degrees) and the length is 4, the final Coordinate
     * will be (5.9) plus the corresponding inside it, therefore
     * from (5,5) to (5,8).
     */
    private void applyShipCoordinate() {
        int count = 0;
        for (int i = 0; i < this.length; i++) {
            switch (this.direction) {
                case 1 -> {
                    this.coordinatesOccupies[i] = new Coordinate(this.start.getXPoint() + i, this.start.getYPoint());
                    count++;
                    if (count == this.length)
                        this.end = this.coordinatesOccupies[count - 1];

                }
                case 2 -> {
                    this.coordinatesOccupies[i] = new Coordinate(this.start.getXPoint(), this.start.getYPoint() + i);
                    count++;
                    if (count == this.length)
                        this.end = this.coordinatesOccupies[count - 1];
                }

                case 3 -> {
                    this.coordinatesOccupies[i] = new Coordinate(this.start.getXPoint() - i, this.start.getYPoint());
                    count++;
                    if (count == this.length)
                        this.end = this.coordinatesOccupies[count - 1];
                }
                case 4 -> {
                    this.coordinatesOccupies[i] = new Coordinate(this.start.getXPoint(), this.start.getYPoint() - i);
                    count++;
                    if (count == this.length)
                        this.end = this.coordinatesOccupies[count - 1];
                }
            }
        }
    }
}
