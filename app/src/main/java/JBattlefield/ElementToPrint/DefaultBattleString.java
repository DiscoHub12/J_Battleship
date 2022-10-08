package JBattlefield.ElementToPrint;

import JBattlefield.Model.Coordinate;
import JBattlefield.Model.DefaultBattlePlane;

/**
 * This class provides a default implementation of the
 * StringOfElement funcitonal interface.
 * Provides a rapresentation in the form of a String of
 * DefaultBattlePlane class, i.e it rapresents the Coordinates
 * hit by the Player, and any Ship of the opponent that
 * managed to sink.
 */
public class DefaultBattleString implements StringOfElement<DefaultBattlePlane> {


    /**
     * This Object is needed to provide a String
     * rapresentation of Coordinate, offered by the
     * CoordinateString class.
     */
    private final CoordinateString coordinateString = new CoordinateString();

    @Override
    public String printOfElement(DefaultBattlePlane element) {
        return "\nDefaultBattle:" + printAllCoordinatesHitten(element);
    }

    private String printAllCoordinatesHitten(DefaultBattlePlane element) {
        String tmp = "";
        if (element.hitPosition().isEmpty())
            tmp = "Nothing player hit.";
        int c = 1;
        for (Coordinate coord : element.hitPosition().keySet()) {
            tmp += "\nCoord hit " + c + ": " + coordinateString.printOfElement(coord);
            c++;
        }
        return tmp;
    }
}
