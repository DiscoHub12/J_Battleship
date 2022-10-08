package JBattlefield.ElementToPrint;

import JBattlefield.Model.Ship;

/**
 * This class provides a default implementation of the
 * StringOfElement funcitonal interface.
 * Provides a String rapresentation of a Ship, i.e of the
 * Ship class. Then it will rapresent the starting, the ending
 * Coordinate, length and direction of the Ship.
 */
public class ShipString implements StringOfElement<Ship> {

    /**
     * This Object is needed to provide a String
     * rapresentation of Coordinate, offered by the
     * CoordinateString class.
     */
    private final CoordinateString coordString = new CoordinateString();

    @Override
    public String printOfElement(Ship element) {
        return " start" + coordString.printOfElement(element.getStart()) +
                ", end" + coordString.printOfElement(element.getEnd()) +
                ", lenght " + element.getLength() +
                ", direction " + element.getDirection();
    }
}
