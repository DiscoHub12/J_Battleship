package JBattlefield.Model;


/**
 * This class provides a default implementation of the
 * Position interface.
 * Its purpose is to rapresent the concept of Coordinate
 * within a Cartesian plane, in fact it has two atributes, which
 * respecively rapresent a point x and y within a Plane.
 */
public class Coordinate implements Position {

    /**
     * This attribute indicate a point
     * X of a Coordinate taking into consideration
     * a Cartesian Plane.
     */
    private int xPoint;

    /**
     * This attribute indicate a point
     * Y of a Coordinate taking into considerating
     * a Cartesian Plane.
     */
    private int yPoint;

    /**
     * Construction of a Coordinate given an
     * x and y point. Calls the set methods which checks
     * the positive value of point x and y.
     *
     * @param x the x point of Coordinate.
     * @param y the y point of Coordinate.
     */
    public Coordinate(int x, int y) {
        this.setXPoint(x);
        this.setYPoint(y);
    }

    @Override
    public int getXPoint() {
        return this.xPoint;
    }

    @Override
    public void setXPoint(int x) {
        if (x < 0 || x >= Integer.MAX_VALUE)
            throw new IllegalArgumentException("Illegal X point for this Coordinate.");
        this.xPoint = x;
    }

    @Override
    public int getYPoint() {
        return this.yPoint;
    }

    @Override
    public void setYPoint(int y) {
        if (y < 0 || y >= Integer.MAX_VALUE)
            throw new IllegalArgumentException("Illegal Y point for this Coordinate.");
        this.yPoint = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (obj instanceof Coordinate tmp) {
            return tmp.getXPoint() == this.getXPoint() && tmp.getYPoint() == this.getYPoint();
        }
        return false;
    }
}
