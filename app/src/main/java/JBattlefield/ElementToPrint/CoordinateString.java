package JBattlefield.ElementToPrint;

import JBattlefield.Model.Coordinate;

/**
 * This class provides a default implementation of the
 * StringOfElement funcitonal interface.
 * Provides a String rapresentation of the Coordinates,
 * that is, of the Coordinate class. It will rapresent
 * a Coordinate having an x point and an y point.
 */
public class CoordinateString implements StringOfElement<Coordinate> {

    @Override
    public String printOfElement(Coordinate element) {
        return "<" + element.getXPoint() + "><" + element.getYPoint() + ">";
    }
}
